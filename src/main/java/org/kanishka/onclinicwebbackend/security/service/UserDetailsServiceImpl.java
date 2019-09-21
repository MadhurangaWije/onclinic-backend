package org.kanishka.onclinicwebbackend.security.service;

import org.kanishka.onclinicwebbackend.model.UserPrinciple;
import org.kanishka.onclinicwebbackend.model.Users;
import org.kanishka.onclinicwebbackend.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@Qualifier("custom-user-details-service")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Users> users= usersRepository.findByEmail(email);
        users.orElseThrow(()->new UsernameNotFoundException("Not Found : "+email));
        return users.map(UserPrinciple::new).get();
    }
}
