package com.social.socialweb.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.social.socialweb.models.User;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class jwtValidator extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
                String jwt = request.getHeader(JwtConstant.JWT_HEADER);

                if (jwt!=null) {
                    try {
                        String email = JwtProvider.getEmailFromJwtToken(jwt);
            
                        List<GrantedAuthority> authorities = new ArrayList<>();
                
                        //this may i changed here
                        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, null, authorities);
                        //org.springframework.security.core.Authentication authentication = new UsernamePasswordAuthenticationToken(email,null, authorities);

                
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                        } catch (Exception e) {
                            throw new BadCredentialsException("Invalid Token.......");
                        }
                    }
                    
                filterChain.doFilter(request, response);

                //throw new UnsupportedOperationException("Unimplemented method 'doFilterInternal'");
    }
}

    





