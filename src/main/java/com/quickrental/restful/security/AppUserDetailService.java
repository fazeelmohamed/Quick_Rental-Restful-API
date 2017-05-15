package com.quickrental.restful.security;

import com.quickrental.restful.model.User;
import com.quickrental.restful.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * Created by MF Fazeel Mohamed on 5/14/2017.
 */

@Component
public class AppUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public final UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = this.userService.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User '" + username + "' not found");
        }

        //return new org.springframework.security.core.userdetails.User(username, user.getPassword(), Collections.emptyList());

         return new org.springframework.security.core.userdetails.User(username, user.getPassword(),true,true,
                true, true, Collections.emptyList());

    }
}
