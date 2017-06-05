package com.ednTISolutions.controleHoras.security;

import com.ednTISolutions.controleHoras.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by edneyroldao on 01/05/17.
 */
public class AuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException {
        System.out.println("passou aqui - inicio");
        String token = req.getHeader(TokenUtil.TOKEN_HEADER);
        String username = tokenUtil.getUsernameFromToken(token);

        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails user = this.userDetailsService.loadUserByUsername(username);

            if(tokenUtil.validateToken(token, user)) {
                UsernamePasswordAuthenticationToken auth = null;
                auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }


        System.out.println("passou aqui - fim");
        chain.doFilter(req, res);
    }
}
