package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class BooksController {
    @Autowired
    private BookService bookService;
    @GetMapping("/")
    public String getAllBook(Model model){
        model.addAttribute("books", bookService.getAllBook());
        return "index";

    }
    @GetMapping("/createbook")
    public  String createBook(Model model){
        model.addAttribute("book", new Book());
        return "createbook";
    }
    @PostMapping("/admin/add")
    public  String submitBook(Model model, @ModelAttribute Book book){
        bookService.createBook(book);
        model.addAttribute("books", bookService.getAllBook());
        return  "redirect:/user/admin";
    }
    @GetMapping("/view/{id}")
    public  String viewBook(Model model, @PathVariable Integer id){
        model.addAttribute("book", bookService.getBook(id));
        return  "book-details";
    }
    @GetMapping("/editbook/{id}")
    public  String editBook(Model model, @PathVariable Integer id){
        model.addAttribute("book", bookService.getBook(id));

        return  "editbook";
    }
    @PostMapping("/editbook")
    public  String submitedittedBook(Model model, @ModelAttribute Book book){
        bookService.createBook(book);
        return  "redirect:/book/readall";
    }
    @GetMapping("/delete/{id}")
    public  String deleteBook( @PathVariable Integer id){
        bookService.deleteBook(id);
        return  "redirect:/book/readall";
    }
}


