package com.example.ssn.controllers;

import com.example.ssn.APIResponse;
import com.example.ssn.ApiResponceFactory;
import com.example.ssn.contracts.Roles;
import com.example.ssn.contracts.User;
import com.example.ssn.repositories.UserRepositories;
import com.example.ssn.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserControllers {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public APIResponse getUsers(){
               return ApiResponceFactory.success(userService.findAllUsers());
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public APIResponse getUserByDI(@PathVariable Long id){
        return  ApiResponceFactory.success(userService.getUserById(id));
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public APIResponse registr(String firstname, String lastname, Roles role, String username, String password, String position){
        return  ApiResponceFactory.success(userService.registration(firstname, lastname, role, username, password, position));
    }
    /*@RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers(Model model){
        //model.addAttribute("users", userRepositories.findAll());
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public */
}
