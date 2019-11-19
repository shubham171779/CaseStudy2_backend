package com.casestudy2.backendblogging.controller;

import com.casestudy2.backendblogging.Modal.Users;
import com.casestudy2.backendblogging.exception.ResourceNotFoundException;
import com.casestudy2.backendblogging.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository usr;
    @GetMapping("/allusers")
    public List<Users> getAllUsers()
    {
        return usr.findAll();
    }
    @GetMapping(path = "/allusers/{username}")
    public Users getAllUsers(@PathVariable(value = "username") String username)
    {
        return usr.findAllByUsername(username);
    }
    @GetMapping("/users")
    public Optional<Users> getUser(Principal principal)
    {
        return usr.findByEmail(principal.getName());
    }
    @PutMapping(path = "/updateuser/{id}")
    public Users updateUser(@PathVariable(value = "id") Long id, @RequestBody Users newusr)
    {
        Users user = usr.findById(id).orElseThrow(()-> new ResourceNotFoundException("Users","user-id",id));
        user.setEmail(newusr.getEmail());
        user.setContact(newusr.getContact());
        user.setGender(newusr.getGender());
        user.setPassword(newusr.getPassword());
        Users updateduser = usr.save(user);
         return updateduser;
    }
    @GetMapping(path="/getuser/{id}")
    public Users getuser(@PathVariable(value = "id") Long id)
    {
        return usr.findById(id).orElseThrow(()-> new ResourceNotFoundException("Users","Id",id));
    }


}
