package com.casestudy2.backendblogging.service;

import com.casestudy2.backendblogging.Modal.Followers;
import com.casestudy2.backendblogging.Modal.Users;
import com.casestudy2.backendblogging.exception.ResourceNotFoundException;
import com.casestudy2.backendblogging.repository.FollowersRepository;
import com.casestudy2.backendblogging.repository.UserRepository;
import com.casestudy2.backendblogging.repository.userRepositaryclass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@Service
public class Followersservice {

    @Autowired
    UserRepository userRepository;
    @Autowired
    userRepositaryclass userRepositaryclass ;
    @Autowired
    FollowersRepository followersRepository;
    public ArrayList<Followers> getfollowing(Principal principal)
    {
        Optional<Users> user = userRepositaryclass.getByEmail(principal.getName());
        ArrayList<Followers> followers = followersRepository.findAllByUsers2(user);
        return followers;
    }

    public String addFollowing(Long id, Principal principal)
    {
        Optional<Users> user =  userRepositaryclass.getById(id);
        Optional<Users> user2 = userRepositaryclass.getByEmail(principal.getName());
        Followers followers = new Followers();
        followers.setUsers(user.get());
        followers.setUsers2(user2.get());
        followersRepository.save(followers);
        return "\"Following\"";

    }
    @Transactional
    public String deletefollowing(Long id,Principal principal)
    {
     Optional<Users> users = userRepositaryclass.getById(id);
     Optional<Users> users2 = userRepositaryclass.getByEmail(principal.getName());
     followersRepository.deleteByUsersAndUsers2(users,users2);
     return "\"Blog Deleted\"";
    }
}
