package com.example.practices.auth.service;

import com.example.practices.auth.dto.UserDTO;
import com.example.practices.auth.entity.UserEntity;
import com.example.practices.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;


public class UserDetailsCustomService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    //@Autowired
    //private EmailService emailService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);
        if(userEntity == null){
            throw new UsernameNotFoundException("Username or password not found");
        }
        return new User(userEntity.getUsername(), userEntity.getPassword(), Collections.emptyList());
    }

    public boolean save(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDTO.getUsername());
        userEntity.setPassword(userDTO.getPassword());
        userEntity = this.userRepository.save(userEntity);
        /*if(userEntity != null){
            emailService.sendWelcomeEmailTo(userEntity.getUsername());
        }*/

        return userEntity != null;


    }


}
