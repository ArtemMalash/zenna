package com.project.store.services;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.project.store.model.Product;
import com.project.store.repos.ProductRepo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service("productService")
@Transactional
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public void writeImageToResponse(byte[] bytes, HttpServletResponse response) {
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.setHeader("Cache-Control", "max-age=2628000");

        try (OutputStream out = response.getOutputStream()) {
            out.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
