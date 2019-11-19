package com.casestudy2.backendblogging.service;

import com.casestudy2.backendblogging.Modal.Blogs;
import com.casestudy2.backendblogging.Modal.Users;
import com.casestudy2.backendblogging.Modal.UsersBlogs;
import com.casestudy2.backendblogging.repository.BlogRepository;
import com.casestudy2.backendblogging.repository.UserRepository;
import com.casestudy2.backendblogging.repository.userRepositaryclass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@Service
public class blogservice {
    @Autowired
    BlogRepository blogRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    userRepositaryclass userRepositaryclass;
    public ArrayList<Blogs> getEmail(Principal principal)
    {
        String email = principal.getName();
        Optional<Users> users = userRepositaryclass.getByEmail(email);
        return blogRepository.findAllByUsers(users);
    }
}
