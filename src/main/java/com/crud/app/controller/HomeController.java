package com.crud.app.controller;

import com.crud.app.dto.UserDTO;
import com.crud.app.model.FormData;
import com.crud.app.service.S3Service;
import com.crud.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired S3Service service;
    @Autowired UserService userService;

    @GetMapping("/index")
    public String index(Model model){

        model.addAttribute("userList",userService.getUserList());
        return "index";
    }
    @GetMapping("/add-data")
    public String addData(){
        return "add-data";
    }

    @PostMapping("/save-data")
    public String saveData(@ModelAttribute UserDTO formModel){
        userService.createUser(formModel);
        return "redirect:/home/add-data";
    }

    @GetMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.delete(id);
        return "redirect:/home/index";
    }
}

//localhost:8080/home/index