package com.javainuse.springbootsecurity.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javainuse.springbootsecurity.dao.enitity.Employer;
import com.javainuse.springbootsecurity.services.IEmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/employer")
public class EmployerController {
    @Autowired
    IEmployerService iEmployerService ;

    @GetMapping("/")
    public List<Employer> getBlog(){
        return  iEmployerService.getAllEmployer();

    }
    @GetMapping("/find")
    public Employer getEmployer(@RequestParam Long id){
        return  iEmployerService.findById(id).orElse(null);

    }

    @DeleteMapping("/remove")
    public boolean deleteEmployer(@RequestParam Long id){
        return  iEmployerService.deleteEmployer(id);

    }
    @PutMapping ("/update")
    public boolean updateEmployer (@RequestBody Employer emp){
        return  iEmployerService.updateEmployer(emp);

    }
    @PostMapping ("/add")
    public Employer addEmployer (@RequestBody Employer emp){
        return  iEmployerService.addUser(emp);

    }
}
