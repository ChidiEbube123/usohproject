package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    @NotBlank(message = "Field is Required")
    private String name;
    private  String author;
    @Column(unique = true)
    @NotBlank(message = "Field is Required")
    private  String description;

    @ManyToOne
    private User user;


    public Book(int id, String name, String author, String description) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
    }

    public Book(){}
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
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getAuthor() {
        return author;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }


}
