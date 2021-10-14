package com.project.store.controllers;

import com.project.store.model.Product;
import com.project.store.repos.CategoryRepo;
import com.project.store.repos.ProductRepo;
import com.project.store.repos.SubcategoryRepo;
import com.project.store.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class ProductController{

    @Autowired
    ProductRepo productRepo;

    private ProductService productService = new ProductService();

    @PostMapping("/newProduct")
    public String addProduct(Product product, @RequestParam("file") MultipartFile file, Model model) throws IOException {

        if(!file.isEmpty()){
            product.setImage(file.getBytes());
        }else{
            product.setImage(null);
        }

        productRepo.save(product);

        return "redirect:/shop";
    }

    @PostMapping("/editProduct")
    public String editProduct(Product product, @RequestParam("file") MultipartFile file, Model model) throws IOException {

        if(!file.isEmpty()){
            product.setImage(file.getBytes());
        }else{
            product.setImage(productRepo.getById(product.getId()).getImage());
        }

        productRepo.save(product);

        return "redirect:/shop";
    }



    @GetMapping("/productImage/{id}")
    public void getImage(@PathVariable("id") Long id, HttpServletResponse response) {
        productService.writeImageToResponse(productRepo.getById(id).getImage(), response);
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable Long id){

        productRepo.deleteById(id);
        return "redirect:/shop";
    }


}
