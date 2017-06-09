package com.ednTISolutions.controleHoras.security.utils;

import com.ednTISolutions.controleHoras.models.User;
import com.ednTISolutions.controleHoras.security.models.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
@PropertySource("classpath:jwt.properties")
public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID = -3301605591108950415L;

    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_AUDIENCE = "audience";
    private static final String CLAIM_KEY_CREATED = "created";

    private static final String AUDIENCE_WEB = "web";
    private static final String AUDIENCE_MOBILE = "mobile";
    private static final String AUDIENCE_TABLET = "tablet";

    public static final String TOKEN_HEADER = "X-Auth-Token";

    @Autowired
    private Environment env;

    public String getUsernameFromToken(String token) {
        String username;
        try {
            final Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
            
        } catch (Exception e) {
        	System.out.println("TokenUtil.getUsernameFromToken it wasn't able to retrieve claims from token");
            username = null;
        }
        
        return username;
    }

    public Date getCreatedDateFromToken(String token) {
        Date created;
        try {
            final Claims claims = getClaimsFromToken(token);
            created = new Date((Long) claims.get(CLAIM_KEY_CREATED));
            
        } catch (Exception e) {
        	System.out.println("TokenUtil.getCreatedDateFromToken it wasn't able to retrieve claims from token");
            created = null;
        }
        
        return created;
    }

    public Date getExpirationDateFromToken(String token) {
        Date expiration;
        try {
            final Claims claims = getClaimsFromToken(token);
            expiration = claims.getExpiration();
            
        } catch (Exception e) {
        	System.out.println("TokenUtil.getExpirationDateFromToken it wasn't able to retrieve claims from token");
            expiration = null;
        }
        
        return expiration;
    }

    public String getAudienceFromToken(String token) {
        String audience;
        try {
            final Claims claims = getClaimsFromToken(token);
            audience = (String) claims.get(CLAIM_KEY_AUDIENCE);
            
        } catch (Exception e) {
        	System.out.println("TokenUtil.getAudienceFromToken it wasn't able to retrieve claims from token");        	
            audience = null;
        }
        
        return audience;
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED, new Date());
        
        return generateToken(claims);
    }

    public String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, env.getProperty("secret"))
                .compact();
    }

    public Boolean canTokenBeRefreshed(String token, Date lastPasswordReset) {
        final Date created = getCreatedDateFromToken(token);
        
        return !isCreatedBeforeLastPasswordReset(created, lastPasswordReset)
                && (!isTokenExpired(token) || ignoreTokenExpiration(token));
    }

    public String refreshToken(String token) {
        String refreshedToken;
        try {
            final Claims claims = getClaimsFromToken(token);
            claims.put(CLAIM_KEY_CREATED, new Date());
            refreshedToken = generateToken(claims);
            
        } catch (Exception e) {
        	System.out.println("TokenUtil.refreshToken it wasn't able to retrieve claims from token");        	
            refreshedToken = null;
        }
        
        return refreshedToken;
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        JwtUser user = (JwtUser) userDetails;
        final String username = getUsernameFromToken(token);
        final Date created = getCreatedDateFromToken(token);
        //final Date expiration = getExpirationDateFromToken(token);
        
        return (
                username.equals(user.getUsername())
                        && !isTokenExpired(token)
                        && !isCreatedBeforeLastPasswordReset(created, user.getLastPasswordResetDate()));
    }

    public String generateTokenFromNewUser(User user) {
        Map<String, Object> claims = new HashMap<>();

        StringBuilder sb = new StringBuilder(user.getUsername());
        sb.append(";");
        sb.append(user.getPassword());
        sb.append(";");
        sb.append(user.getFirstname());

        claims.put(CLAIM_KEY_USERNAME, sb.toString());
        claims.put(CLAIM_KEY_AUDIENCE, AUDIENCE_WEB);
        claims.put(CLAIM_KEY_CREATED, new Date());

        Date dateExp = new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(2));
        String tokenGenerated = generateToken(claims, dateExp);
        String changedToken = removeDotFromToken(tokenGenerated);

        return changedToken;
    }

    public User getNewUserFromToken(String token) {
        String rightToken = addDotInToken(token);

        User user = new User();
        String userInfo = getUsernameFromToken(rightToken);
        String[] userToken = userInfo.split(";");

        user.setUsername(userToken[0]);
        user.setPassword(userToken[1]);
        user.setFirstname(userToken[2]);

        return user;
    }

    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(env.getProperty("secret"))
                    .parseClaimsJws(token)
                    .getBody();
            
        } catch (Exception e) {
        	System.out.println("TokenUtil.getClaimsFromToken - There is no claim for token from parameter");
            claims = null;
        }
        
        return claims;
    }

    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(30));
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
        return (lastPasswordReset != null && created.before(lastPasswordReset));
    }

    private Boolean ignoreTokenExpiration(String token) {
        String audience = getAudienceFromToken(token);
        return (AUDIENCE_TABLET.equals(audience) || AUDIENCE_MOBILE.equals(audience));
    }

    private String removeDotFromToken(String token) {
        return token.replace(".", env.getProperty("replaceDot"));
    }

    private String addDotInToken(String token) {
        return token.replace(env.getProperty("replaceDot"), ".");
    }

    private String generateToken(Map<String, Object> claims, Date date) {
        String token  = Jwts.builder()
                .setClaims(claims)
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS512, env.getProperty("secret"))
                .compact();
        
        return token;
    }

}