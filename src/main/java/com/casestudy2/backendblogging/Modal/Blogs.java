package com.casestudy2.backendblogging.Modal;

import javax.persistence.*;

@Entity
public class Blogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @ManyToOne
    private Users users;
    private String name;
    private String img;
    private String heading;
    private String category;
    private String writer;
    private String lastupdated;
    private String detail1;
    private String detail11;
    private String detail12;
    private String h1;
    private String detailh1;
    private String detailh11;
    private String detailh12;
    private String h2;
    private String detailh2;
    private String detailh21;
    private String detailh22;

    public String getDetail11() {
        return detail11;
    }

    public void setDetail11(String detail11) {
        this.detail11 = detail11;
    }

    public String getDetail12() {
        return detail12;
    }

    public void setDetail12(String detail12) {
        this.detail12 = detail12;
    }

    public String getDetailh11() {
        return detailh11;
    }

    public void setDetailh11(String detailh11) {
        this.detailh11 = detailh11;
    }

    public String getDetailh12() {
        return detailh12;
    }

    public void setDetailh12(String detailh12) {
        this.detailh12 = detailh12;
    }

    public String getDetailh21() {
        return detailh21;
    }

    public void setDetailh21(String detailh21) {
        this.detailh21 = detailh21;
    }

    public String getDetailh22() {
        return detailh22;
    }

    public void setDetailh22(String detailh22) {
        this.detailh22 = detailh22;
    }



    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getLastupdated() {
        return lastupdated;
    }

    public void setLastupdated(String lastupdated) {
        this.lastupdated = lastupdated;
    }

    public String getDetail1() {
        return detail1;
    }

    public void setDetail1(String detail1) {
        this.detail1 = detail1;
    }

    public String getH1() {
        return h1;
    }

    public void setH1(String h1) {
        this.h1 = h1;
    }

    public String getDetailh1() {
        return detailh1;
    }

    public void setDetailh1(String detailh1) {
        this.detailh1 = detailh1;
    }

    public String getH2() {
        return h2;
    }

    public void setH2(String h2) {
        this.h2 = h2;
    }

    public String getDetailh2() {
        return detailh2;
    }

    public void setDetailh2(String detailh2) {
        this.detailh2 = detailh2;
    }






}
