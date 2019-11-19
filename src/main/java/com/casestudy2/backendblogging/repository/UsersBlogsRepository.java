package com.casestudy2.backendblogging.repository;

import com.casestudy2.backendblogging.Modal.Blogs;
import com.casestudy2.backendblogging.Modal.Users;
import com.casestudy2.backendblogging.Modal.UsersBlogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface UsersBlogsRepository extends CrudRepository<UsersBlogs,Long> {
 public ArrayList<UsersBlogs> findAllByUsers(Optional<Users> users);
 void deleteByUsersAndBlogs(Optional<Users> users, Optional<Blogs> blogs);

}
