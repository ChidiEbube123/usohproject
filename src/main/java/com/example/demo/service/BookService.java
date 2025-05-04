package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
/*    public Book findByBookTitle(String title) {
        return bookRepo.findByBookTitle(title);
    }*/
    public Book createBook(Book book){
        return bookRepo.save(book);
    }

    public Page<Book> getPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return bookRepo.findAll(pageable);
    }
    public void deleteBook(int id){
        bookRepo.deleteById(id);
    }
}
