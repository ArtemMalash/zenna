package com.project.store.model;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.persistence.*;
import java.io.File;
import java.sql.Blob;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SUBCATEGORY_ID")
    private Subcategory subcategory;

    @Column(name="PRODUCT_NAME")
    private String product_name;

    @Column(name="BRAND")
    private String brand;


    @Column(name="COLOR")
    private String color;

    @Column(name="MATERIAL")
    private String material;

    @Column(name="PRICE")
    private Double price;

    @Lob
    @Column(name="IMAGE")
    private byte[] image;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public byte[] get64Image(){
        return Base64.encodeBase64(image);
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
