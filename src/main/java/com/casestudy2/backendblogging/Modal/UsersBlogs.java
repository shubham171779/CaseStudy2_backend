package com.casestudy2.backendblogging.Modal;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class UsersBlogs implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    private int quantity;
    @ManyToOne
    private Blogs blogs;
    @ManyToOne
    private Users users;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Blogs getBlogs() {
        return blogs;
    }

    public void setBlogs(Blogs blogs) {
        this.blogs = blogs;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }



}
