package com.example.demo.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String role;

    @OneToMany(mappedBy = "user")
    private List<Book> likedbooks;

    public User(int id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;


    }
    public User(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
