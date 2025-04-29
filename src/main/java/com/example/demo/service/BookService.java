package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;
    public List<Book> getAllBook(){
        return bookRepo.findAll();
    }
    public Book getBook(int id){
        return bookRepo.findById(id).get();
    }
    public Book createBook(Book book){
        return bookRepo.save(book);
    }
    public void deleteBook(int id){
        bookRepo.deleteById(id);
    }
}
