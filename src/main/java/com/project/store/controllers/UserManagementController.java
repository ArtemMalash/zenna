package com.project.store.controllers;

import com.project.store.model.User;
import com.project.store.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserManagementController {

    @Autowired
    UserRepo userRepo;

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id){

        userRepo.deleteById(id);
        return "redirect:/userManagement";
    }

    @GetMapping("/changeUserRole/{email}")
    public String changeUserRole(@PathVariable String email){

        User user = userRepo.findByEmail(email);

        if(user.getRole_id() == 2) {
            user.setRole_id(3);
        } else{
            user.setRole_id(2);
        }

        userRepo.save(user);

        return "redirect:/userManagement";
    }
}
