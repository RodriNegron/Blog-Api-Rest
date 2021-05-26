package com.blogapi.blogapi.models;

import javax.persistence.Entity;

import javax.persistence.*;

@Entity
@Table(name = "caregory")
public class CaterogyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String name;
    

    public CaterogyModel(){
    }

    public CaterogyModel(String name) {
        this.name = name;
    }
    
    //region Getters & setters

    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    //endrergion
}
