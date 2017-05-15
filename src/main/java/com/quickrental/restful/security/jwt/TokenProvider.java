package com.quickrental.restful.security.jwt;

import com.quickrental.restful.AppConfig;
import com.quickrental.restful.model.User;
import com.quickrental.restful.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;
import java.util.UUID;

/**
 * Created by MF Fazeel Mohamed on 5/14/2017.
 */

@Component
public class TokenProvider {

    private final String secretKey;

    private final long tokenValidityInMilliseconds;

    private final UserDetailsService userDetailsService;

    @Autowired
    UserService userService;



    public TokenProvider(AppConfig config, UserDetailsService userDetailsService) {
        this.secretKey = Base64.getEncoder()
                .encodeToString(config.getSecret().getBytes());
        this.tokenValidityInMilliseconds = 1000 * config.getTokenValidityInSeconds();
        this.userDetailsService = userDetailsService;
    }

    public String createToken(String username) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + this.tokenValidityInMilliseconds);

        User user = this.userService.findByUsername(username);
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("userId", user.getId() + "");
        claims.put("role", user.getUserRole());

        return Jwts.builder().setId(UUID.randomUUID().toString())
                .setClaims(claims)
                .setSubject(username).setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS512, this.secretKey).setExpiration(validity)
                .compact();
    }

    public Authentication getAuthentication(String token) {
        String username = Jwts.parser().setSigningKey(this.secretKey).parseClaimsJws(token)
                .getBody().getSubject();
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

        return new UsernamePasswordAuthenticationToken(userDetails, "",
                userDetails.getAuthorities());
    }
}
