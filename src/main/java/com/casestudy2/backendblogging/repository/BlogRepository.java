package com.casestudy2.backendblogging.repository;

import com.casestudy2.backendblogging.Modal.Blogs;
import com.casestudy2.backendblogging.Modal.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<Blogs,Long> {
    List<Blogs> findAllByCategory(String cat);
    List<Blogs> findAllByWriter(String writer);
    public ArrayList<Blogs> findAllByUsers(Optional<Users> users);

}
