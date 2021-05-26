package com.blogapi.blogapi.models;

import javax.persistence.Entity;

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
    private boolean active=true; 
    
    /* @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false )
    private UserModel user;  */
    
    public PostModel(){

    }

    public PostModel(String title, String content, String image) {
        this.title = title;
        this.content = content;
        this.image = image;
    }
 
    //region Getters & setters

   /*  public UserModel getUser() {
        return user;
    }
    public void setUser(UserModel user) {
        this.user = user;
    } */

    public void setTitle(String title) {
        this.title = title;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setImage(String image) {
        this.image = image;
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
    public Integer getId() {
        return id;
    }
    public Boolean getActive(){
        return active;
    } 
    //endregion
}
