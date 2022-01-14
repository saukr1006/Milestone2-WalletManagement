package com.example.walletapi.controller;

import com.example.walletapi.entity.User;
import com.example.walletapi.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private WalletService service;

    @GetMapping("/home")
    public List<User> show(){
        return service.listAll();
    }

    @PostMapping("/user")
    public void createUser(@RequestBody User user){
        user.setCreatedAt(new Date());
        service.saveUser(user);
    }

}
