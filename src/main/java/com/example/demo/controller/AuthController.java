package com.example.demo.controller;

import com.example.demo.model.User;
 import com.example.demo.service.UserService;
 import jakarta.servlet.http.HttpServletRequest;
 import jakarta.validation.Valid;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.data.domain.Page;
 import org.springframework.stereotype.Controller;
 import org.springframework.ui.Model;
 import org.springframework.validation.BindingResult;
 import org.springframework.web.bind.annotation.*;

 import java.security.Principal;

 @Controller
 @RequestMapping("/")
 public class AuthController {

 @Autowired
 private UserService userService;

 @GetMapping("/register")
 public String showRegisterForm(Model model) {
 model.addAttribute("user", new User());
 return "register";
 }

 @PostMapping("/register")
 public String register(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
 if (result.hasErrors()){
 return "register";
 }
 userService.save(user);
  System.out.println("E dey work");

  return "redirect:/login";
 }

 @GetMapping("/login")
 public String login() {
 return "login";
 }

 @GetMapping("/home")
 public String home(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "1") int size, Principal principal) {
 String email = principal.getName();
 User user = userService.findByEmail(email);
 Page<User> userPage = userService.getPagination(page, size);
 model.addAttribute("users",userPage);
 model.addAttribute("authUser",user);
 return "home";
 }

 }