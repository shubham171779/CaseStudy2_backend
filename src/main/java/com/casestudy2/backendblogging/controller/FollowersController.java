package com.casestudy2.backendblogging.controller;

import com.casestudy2.backendblogging.Modal.Followers;
import com.casestudy2.backendblogging.service.Followersservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/follow")
public class FollowersController {
@Autowired
    Followersservice followersservice;
    @GetMapping("/addfollowing/{userid}")
    private String follow(@PathVariable("userid") Long userid, Principal principal)
    {
        return followersservice.addFollowing(userid,principal);
    }
    @GetMapping(path = "/following")
    private ArrayList<Followers> getfollowers(Principal principal)
    {
        return followersservice.getfollowing(principal);
    }
    @GetMapping(path = "/delete/{id}")
    private String deletefollow(@PathVariable("id") Long id,Principal principal)
    {
        return followersservice.deletefollowing(id,principal);
    }


}
