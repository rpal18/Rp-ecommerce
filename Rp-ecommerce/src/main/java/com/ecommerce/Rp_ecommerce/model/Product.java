package com.ecommerce.Rp_ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    @Size(min = 3 , message = "productName should be of atleast 3 character")
    private String productName;
    @NotBlank
    @Size(min = 6 , message = "description should be of atleast 6 character")
    private String description;
    private Integer quantity;

    private String image;

    private double price;
    private double discount;
    private double specialPrice;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User user ;
    @OneToMany(mappedBy = "product" , cascade = {CascadeType.MERGE , CascadeType.PERSIST , CascadeType.REMOVE} , fetch = FetchType.EAGER)
    private List<CartItem> products = new ArrayList<>();
    public Product( String productName, String description, Integer quantity, String image, double price, double discount, double specialPrice, Category category) {
        this.productName = productName;
        this.description = description;
        this.quantity = quantity;
        this.image = image;
        this.price = price;
        this.discount = discount;
        this.specialPrice = specialPrice;
        this.category = category;
    }

    public Product() {
    }


    @ManyToOne
    @JoinColumn(name = "category_category_id")
    private Category category;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(double specialPrice) {
        this.specialPrice = specialPrice;
    }
}
