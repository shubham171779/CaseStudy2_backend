package com.casestudy2.backendblogging.controller;

import com.casestudy2.backendblogging.Modal.Blogs;
import com.casestudy2.backendblogging.exception.ResourceNotFoundException;
import com.casestudy2.backendblogging.repository.BlogRepository;
import com.casestudy2.backendblogging.service.blogservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.concurrent.BlockingDeque;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogRepository blogRepository;
    @Autowired
    blogservice blogservice;
    @PostMapping("/add")
    public Blogs addblog(@Valid @RequestBody Blogs blog)
    {
        return blogRepository.save(blog);

    }
    @GetMapping(path = "/get")
    public List<Blogs> getblogs(){
        return blogRepository.findAll();
    }
    @GetMapping("/get/{id}")
    public Blogs getblog(@PathVariable("id") Long id){
        return blogRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Blogs","Id",id));
    }
    @GetMapping("/get/cat/{cat}")
    public List<Blogs> getblogsbycategory(@PathVariable("cat") String cat)
    {
        return blogRepository.findAllByCategory(cat);
    }
    @GetMapping(path ="/get/owner")
    public List<Blogs> getblogbyowner(Principal principal)
    {
    return blogservice.getEmail(principal);
    }
    @GetMapping("/get/writer/{writer}")
    public List<Blogs> getblogsbywriter(@PathVariable("writer") String writer)
    {
        return blogRepository.findAllByWriter(writer);
    }
    @GetMapping(path = "/delete/{id}")
    public void deleteblog(@PathVariable("id") Long id)
    {
         blogRepository.deleteById(id);
    }
}
