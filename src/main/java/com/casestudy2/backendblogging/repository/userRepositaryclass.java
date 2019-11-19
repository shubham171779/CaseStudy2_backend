package com.casestudy2.backendblogging.repository;

import com.casestudy2.backendblogging.Modal.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class userRepositaryclass {
    @Autowired
    UserRepository userRepository;
    public Optional<Users> getByEmail(String email)
    {
        System.out.println("Getting by email");
        return userRepository.findByEmail(email);
    }
    public Optional<Users> getById(Long id)
    {
        System.out.println("Getting by id");
        return userRepository.findById(id);
    }
}
