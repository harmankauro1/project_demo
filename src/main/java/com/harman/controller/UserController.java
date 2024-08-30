package com.harman.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.harman.entity.UserPojo;
import com.harman.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/")
    public String homepage()
    {
    	return "index";
    }

    @GetMapping("/listuser")
    public String viewHomePage(Model model) {
        model.addAttribute("listUsers", userService.getAllUsers());
        return "listuser";
    }

    @GetMapping("/showNewUserForm")
    public String showNewUserForm(Model model) {
        UserPojo user = new UserPojo();
        model.addAttribute("user", user);
        return "new_user";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") UserPojo user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        UserPojo user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "update_user";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") long id) {
        this.userService.deleteUserById(id);
        return "redirect:/";
    }
}

