package fr.el.g2l.gateway.internal.service;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.el.g2l.referentiel.api.UserApi;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GatewayUserDetailsService implements UserDetailsService {
    
    private final UserApi userApi;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userApi.findByUsername(username)
                    .map(user -> new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        user.getPassword(),
                        Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"))
                    ))
                    .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
    