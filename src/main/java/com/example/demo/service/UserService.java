package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public List<User> getAllUsers(){
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
}
