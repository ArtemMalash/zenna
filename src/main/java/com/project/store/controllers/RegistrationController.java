package com.project.store.controllers;

import com.project.store.model.User;
import com.project.store.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/registration")
    public String addUser(User user, Model model){

        User userFromDb = userRepo.findByEmail(user.getEmail());

        if(userFromDb != null) {
            model.addAttribute("message", "User is exists!!!");
            return "registration";
        }

        user.setRole_id(2); //User_id
        userRepo.save(user);

        return "redirect:/login";
    }

}
