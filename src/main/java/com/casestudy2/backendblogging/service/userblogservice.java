package com.casestudy2.backendblogging.service;

import com.casestudy2.backendblogging.Modal.Blogs;
import com.casestudy2.backendblogging.Modal.Users;
import com.casestudy2.backendblogging.Modal.UsersBlogs;
import com.casestudy2.backendblogging.repository.BlogRepository;
import com.casestudy2.backendblogging.repository.UserRepository;
import com.casestudy2.backendblogging.repository.UsersBlogsRepository;
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
public class userblogservice {
    @Autowired
    BlogRepository blogRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UsersBlogsRepository usersBlogsRepository;
    @Autowired
    userRepositaryclass userRepositaryclass;

    public ArrayList<UsersBlogs> getUsersBlogsfromUser(Principal principal)
    {
        Optional<Users> users = userRepositaryclass.getByEmail(principal.getName());
        ArrayList<UsersBlogs> blogs = usersBlogsRepository.findAllByUsers(users);
        return blogs;
    }
    public String addblog(Long id, Principal principal)
    {
        Optional<Blogs> blogs = blogRepository.findById(id);
        Optional<Users> users = userRepositaryclass.getByEmail(principal.getName());
        UsersBlogs usersBlogs = new UsersBlogs();
        usersBlogs.setBlogs(blogs.get());
        usersBlogs.setUsers(users.get());
        usersBlogsRepository.save(usersBlogs);
        return "\"Blog added\"";
    }
    @Transactional
    public String deleteblog(Long id,Principal principal)
    {
        Optional<Blogs> blogs = blogRepository.findById(id);
        Optional<Users> users = userRepositaryclass.getByEmail(principal.getName());
        usersBlogsRepository.deleteByUsersAndBlogs(users,blogs);
        return "\"Blog deleted\"";
    }
}
