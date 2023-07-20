package com.credibanco.loginback.auth.infrastructure.security;


import com.credibanco.loginback.shared.user.domain.entity.User;
import com.credibanco.loginback.shared.user.infrastructure.entrypoint.repository.IRepositoryUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    @Autowired
    IRepositoryUser iRepositoryUser;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = iRepositoryUser
                .findOneByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found."));

        return new UserDetailsImpl(user);
    }
}




