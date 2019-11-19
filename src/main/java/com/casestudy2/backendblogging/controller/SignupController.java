package com.casestudy2.backendblogging.controller;

import com.casestudy2.backendblogging.Modal.Users;
import com.casestudy2.backendblogging.exception.ResourceNotFoundException;
import com.casestudy2.backendblogging.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/signup")
public class SignupController {
    @Autowired
    UserRepository usr;
    @PostMapping(path = "/savedata", consumes = "application/json")
    public Users signup(@RequestBody Users user)
    {
        user.setActive(1);
        user.setAuthentication("basic ");
        usr.save(user);
        return user;
    }
    @GetMapping(path = "/getdata/{id}")
    public Users getuser(@PathVariable(value = "id") Long id)
    {
        return usr.findById(id).orElseThrow(()-> new ResourceNotFoundException("users","id",id));
    }
}



