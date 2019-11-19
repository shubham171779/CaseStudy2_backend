package com.casestudy2.backendblogging.controller;

import com.casestudy2.backendblogging.Modal.Blogs;
import com.casestudy2.backendblogging.Modal.UsersBlogs;
import com.casestudy2.backendblogging.repository.UsersBlogsRepository;
import com.casestudy2.backendblogging.service.userblogservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/userblogs")
public class UsersBlogsController {
    @Autowired
    UsersBlogsRepository usersBlogsRepository;
    @Autowired
    userblogservice userblogservice;
    @GetMapping(path = "/userblog/addblog/blog/{id}")
    public String addblog(@PathVariable("id") Long id, Principal principal)
    {
       return userblogservice.addblog(id,principal);
    }

    @GetMapping(path = "/myblog")
    public ArrayList<UsersBlogs> getblogs(Principal principal)
    {
            return userblogservice.getUsersBlogsfromUser(principal);
    }
    @GetMapping("/myblog/deleteblog/{id}")
    public String deleteblog(@PathVariable("id") Long id, Principal principal)
    {
        return userblogservice.deleteblog(id,principal);
    }
}
