package com.casestudy2.backendblogging.Modal;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Followers implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long Id;
    @ManyToOne
    private Users users;
    @ManyToOne
    private Users users2;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Users getUsers2() {
        return users2;
    }

    public void setUsers2(Users users2) {
        this.users2 = users2;
    }




}
