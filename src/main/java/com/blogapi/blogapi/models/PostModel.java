package com.blogapi.blogapi.models;

import javax.persistence.Entity;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class PostModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;
    private String image;
    private String category;
    private Date release_date;
    private boolean active;
    
    //region Getters & setters
    
    public void setTitle(String title) {
        this.title = title;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
    public String getImage() {
        return image;
    }
    public String getCategory() {
        return category;
    }
    public Date getRelease_date() {
        return release_date;
    }
    public Integer getId() {
        return id;
    }

    public Boolean getActive(){
        return active;
    }
    //endregion
}
