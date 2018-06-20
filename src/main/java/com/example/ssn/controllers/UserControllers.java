package com.example.ssn.controllers;

import com.example.ssn.User;
import com.example.ssn.repositories.UserRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserControllers {
    private UserRepositories userRepositories;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsers(Model model){
       //model.addAttribute("users", userRepositories.findAll());
        return "users";
    }
}
