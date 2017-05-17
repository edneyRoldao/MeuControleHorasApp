package com.ednTISolutions.controleHoras.utils;

import com.ednTISolutions.controleHoras.models.User;
import com.ednTISolutions.controleHoras.security.JwtUserDetails;
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

/**
 * Created by edneyroldao on 30/04/17.
 */
@Component
@PropertySource("classpath:jwt.properties")
public class TokenUtil implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private Environment env;
    
    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_AUDIENCE = "audience";
    private static final String CLAIM_KEY_CREATED = "created";

    private static final String AUDIENCE_WEB = "web";
    private static final String AUDIENCE_MOBILE = "mobile";
    private static final String AUDIENCE_TABLET = "tablet";

    public static final String TOKEN_HEADER = "X-Auth-Token";

    public String getUsernameFromToken(String token) {
        String username;
        try {

            final Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();

        } catch (Exception e) {
        	e.printStackTrace();
            username = null;
        }

        return username;
    }

    public User getNewUserFromToken(String token) {
    	String rightToken = addDotInToken(token);
    	
		User user = new User();
		String userInfo = getUsernameFromToken(rightToken);
		String[] userToken = userInfo.split(";");
		 
		user.setUsername(userToken[0]);
		user.setEmail(userToken[1]);
		user.setPassword(userToken[2]);
		
		return user;
    }

    public Date getCreatedDateFromToken(String token) {
        Date dateCreated;
        try {

            final Claims claims = getClaimsFromToken(token);
            Long msSeconds = (Long) claims.get(CLAIM_KEY_CREATED);
            dateCreated = new Date(msSeconds);

        } catch (Exception e) {
        	e.printStackTrace();
            dateCreated = null;
        }

        return dateCreated;
    }

    public Date getExpirationDateFromToken(String token) {
        Date expDate;
        try {

            final Claims claims = getClaimsFromToken(token);
            expDate = claims.getExpiration();

        } catch (Exception e) {
        	e.printStackTrace();
            expDate = null;
        }

        return expDate;
    }

    public String getAudienceFromToken(String token) {
        String audience;
        try {

            final Claims claims = getClaimsFromToken(token);
            audience = (String) claims.get(CLAIM_KEY_AUDIENCE);

        } catch (Exception e) {
        	e.printStackTrace();
            audience = null;
        }

        return audience;
    }

    public String generateToken(UserDetails user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, user.getUsername());
        claims.put(CLAIM_KEY_AUDIENCE, AUDIENCE_WEB);
        claims.put(CLAIM_KEY_CREATED, new Date());

        String tokenGenerated = generateToken(claims, new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(30)));

        return tokenGenerated;
    }

    public String generateTokenFromNewUser(User user) {
        Map<String, Object> claims = new HashMap<>();

        StringBuilder sb = new StringBuilder(user.getUsername());
        sb.append(";");
        sb.append(user.getEmail());
        sb.append(";");
        sb.append(user.getPassword());

        claims.put(CLAIM_KEY_USERNAME, sb.toString());
        claims.put(CLAIM_KEY_AUDIENCE, AUDIENCE_WEB);
        claims.put(CLAIM_KEY_CREATED, new Date());

        Date dateExp = new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(2));
        String tokenGenerated = generateToken(claims, dateExp);
        String changedToken = removeDotFromToken(tokenGenerated);

        return changedToken;
    }

    public Boolean canTokenBeRefreshed(String token, Date lastPasswordReset) {
        final Date dateCreated = getCreatedDateFromToken(token);
        return isCreatedAfterLastPasswordReset(dateCreated, lastPasswordReset) &&
                (isTokenNotExpired(token) || ignoreTokenExpiration(token));
    }

    public String refreshToken(String token) {
        String refreshedToken;
        try {

            final Claims claims = getClaimsFromToken(token);
            claims.put(CLAIM_KEY_CREATED, new Date());
            refreshedToken = generateToken(claims, new Date(TimeUnit.MINUTES.toMillis(30)));

        } catch (Exception e ) {
        	e.printStackTrace();
            refreshedToken = null;
        }

        return refreshedToken;
    }

    public Boolean validateToken(String token, UserDetails userDetail) {
        JwtUserDetails user = (JwtUserDetails) userDetail;
        final String username = getUsernameFromToken(token);
        final Date dateCreated = getCreatedDateFromToken(token);
        //final Date dateExpiration = getExpirationDateFromToken(token);

        return (username.equals(user.getUsername())
                && (isTokenNotExpired(token))
                && (isCreatedAfterLastPasswordReset(dateCreated, user.getLastPasswordReset())));
    }
    
    private String generateToken(Map<String, Object> claims, Date date) {
        String token  = Jwts.builder()
                            .setClaims(claims)
                            .setExpiration(date)
                            .signWith(SignatureAlgorithm.HS512, env.getProperty("secret"))
                            .compact();
        return token;
    }


    private Boolean ignoreTokenExpiration(String token) {
        String audience = getAudienceFromToken(token);
        return (AUDIENCE_TABLET.equals(audience) || AUDIENCE_MOBILE.equals(audience));
    }

    private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
        return lastPasswordReset != null && created.before(lastPasswordReset);
    }

    private Boolean isCreatedAfterLastPasswordReset(Date created, Date lastPasswordReset) {
        return !isCreatedBeforeLastPasswordReset(created, lastPasswordReset);
    }

    private Boolean isTokenExpired(String token) {
        final Date tokenDate = getExpirationDateFromToken(token);
        return tokenDate.before(new Date());
    }

    private Boolean isTokenNotExpired(String token) {
        return !isTokenExpired(token);
    }

    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(env.getProperty("secret"))
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
        	e.printStackTrace();
            claims = null;
        }
        return claims;
    }

    private String removeDotFromToken(String token) {
    	String wrongToken = token.replace(".", env.getProperty("replaceDot"));
    	return wrongToken;
    }
    
    private String addDotInToken(String wrongToken) {
    	String token = wrongToken.replace(env.getProperty("replaceDot"), ".");
    	return token;
    }

}
