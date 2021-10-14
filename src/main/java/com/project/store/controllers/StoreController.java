package com.project.store.controllers;

import com.project.store.model.Category;
import com.project.store.model.Product;
import com.project.store.model.Subcategory;
import com.project.store.repos.CategoryRepo;
import com.project.store.repos.ProductRepo;
import com.project.store.repos.SubcategoryRepo;
import com.project.store.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


@Controller
public class StoreController {
    @Autowired
    SubcategoryRepo subcategoryRepo;

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ProductRepo productRepo;

    public List<Subcategory> getListSubcategories()
    {
        List<Subcategory> listSubcategory = subcategoryRepo.findAll();

        Collections.sort(listSubcategory, new Comparator<Subcategory>() {
            @Override
            public int compare(Subcategory lhs, Subcategory rhs) {

                return lhs.getCategory().getId() > rhs.getCategory().getId()  ? -1 : (lhs.getCategory().getId()  < rhs.getCategory().getId() ) ? 1 : 0;
            }
        });

        return listSubcategory;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("listSubcategory", getListSubcategories());
        model.addAttribute("listCategory", categoryRepo.findAll());
        model.addAttribute("listProduct", productRepo.findAll());
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model model){
        return "registration";
    }

    @GetMapping("/userManagement")
    public String userManager(Model model){
        model.addAttribute("users", userRepo.findAll());
        model.addAttribute("listSubcategory", getListSubcategories());
        model.addAttribute("listCategory", categoryRepo.findAll());
        return "userManagement";
    }

    //не забудь добавить в securityCfg и добавить в бд LongBlob 'image'
    @GetMapping("/newProduct")
    public String newProduct(Model model) {
        model.addAttribute("listSubcategory", getListSubcategories());
        model.addAttribute("listCategory", categoryRepo.findAll());
        return "newProduct";
    }

    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("listSubcategory", getListSubcategories());
        model.addAttribute("listCategory", categoryRepo.findAll());
        model.addAttribute("listProduct", productRepo.findAll());
        return "about";
    }

    @GetMapping("/shop")
    public String shop(Model model){
        model.addAttribute("listSubcategory", getListSubcategories());
        model.addAttribute("listCategory", categoryRepo.findAll());
        model.addAttribute("listProduct", productRepo.findAll());
        return "shop";
    }


    @GetMapping("/editProduct/{id}")
    public String editProduct(@PathVariable Long id, Model model){

        model.addAttribute("listSubcategory", getListSubcategories());
        model.addAttribute("listCategory", categoryRepo.findAll());
        model.addAttribute("listProduct", productRepo.findAll());
        model.addAttribute("productItem", productRepo.getById(id));

        return "editProduct";
    }

}
