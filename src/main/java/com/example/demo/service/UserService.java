package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Encrypt password
        userRepo.save(user);
    }    public List<User> getAllUsers(){
        return userRepo.findAll();
    }
    public User getUser(int id){
        return userRepo.findById(id).get();
    }
    public User createUser(User user){
        return userRepo.save(user);
    }
    public void deleteUser(int id){
        userRepo.deleteById(id);
    }
    public User findByEmail(String username) {
        return userRepo.findByEmail(username);
    }
    public Page<User> getPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepo.findAll(pageable);
    }
}
