package com.casestudy2.backendblogging.repository;

import com.casestudy2.backendblogging.Modal.Followers;
import com.casestudy2.backendblogging.Modal.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface FollowersRepository extends CrudRepository<Followers,Long> {
    public ArrayList<Followers> findAllByUsers2(Optional<Users> users);
    public void deleteByUsersAndUsers2(Optional<Users> users,Optional<Users> users2);

}
