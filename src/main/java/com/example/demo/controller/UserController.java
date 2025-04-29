package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/createuser")
    public  String createCustomer(Model model){
         return "createuser";
    }
    @PostMapping("/createuser")
    public  String submitUser(Model model, @ModelAttribute User user){
        userService.createUser(user);
        return  "redirect:/readall";
    }
    @GetMapping("/edituser/{id}")
    public  String editUser(Model model, @PathVariable Integer id){
        model.addAttribute("user", userService.getUser(id));

        return  "edituser";
    }
    @PostMapping("/edituser")
    public  String submitedittedUser(Model model, @ModelAttribute User user){
        userService.createUser(user);
        return  "redirect:/allcust";
    }

    @GetMapping("/admin")
    public String admin(Model model){
        model.addAttribute("book",new Book());
        return "admin";

    }
    @GetMapping("/delete/{id}")
    public  String deleteUser( @PathVariable Integer id){
        userService.deleteUser(id);
        return  "redirect:/readall";
    }
}
