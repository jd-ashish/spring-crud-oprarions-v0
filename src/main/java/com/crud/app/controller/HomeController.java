package com.crud.app.controller;

import com.crud.app.model.FormData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }
    @GetMapping("/add-data")
    public String addData(){
        return "add-data";
    }

    @PostMapping("/save-data")
    public String saveData(@ModelAttribute FormData formModel){
        System.out.println("data saved "+formModel.toString());
        return "redirect:/home/add-data";
    }
}

//localhost:8080/home/index