package com.javainuse.springbootsecurity.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javainuse.springbootsecurity.dao.enitity.Employer;
import com.javainuse.springbootsecurity.dao.enitity.User;
import com.javainuse.springbootsecurity.services.Impl.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    ServletContext context;
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/")
    public List<User> getUsers(){
        return  userService.getAllUsers();

    }


    @PostMapping("/regg")
    public ResponseEntity<?> saveUser(@RequestBody User user) throws Exception {


        return ResponseEntity.ok(userService.addUser(user));
    }

    @GetMapping("/userinfo/{email}")
    public User getUser(@PathVariable("email") String email){
        System.out.println("miawwwwwwww"+email);
        return  userService.findByEmaill(email);

    }
    @PutMapping ("/update")
    public boolean updateProduit(@RequestBody User user){
        return  userService.updateUser(user);

    }
}
