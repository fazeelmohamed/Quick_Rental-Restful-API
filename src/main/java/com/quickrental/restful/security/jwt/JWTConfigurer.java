package com.quickrental.restful.security.jwt;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by MF Fazeel Mohamed on 5/14/2017.
 */
public class JWTConfigurer
        extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final TokenProvider tokenProvider;

    public JWTConfigurer(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }


    @Override
    public void configure(HttpSecurity http) throws Exception {
        JWTFilter customFilter = new JWTFilter(this.tokenProvider);
        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
