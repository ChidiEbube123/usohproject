package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Name is required")
    private String name;
    @Column(unique = true)
    @Email(message = "Invalid email")
    private  String email;
    @NotBlank(message = "Field is Required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    private String role;

    @OneToMany(mappedBy = "user")
    private List<Book> likedbooks;

    public User(int id, String name, String email, String password, String role) {
        this.id = id;
        this.name = name;
        this.email=email;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
