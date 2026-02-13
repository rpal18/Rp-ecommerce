package com.ecommerce.Rp_ecommerce.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "cart" , cascade = {CascadeType.PERSIST , CascadeType.REMOVE , CascadeType.MERGE} ,
            orphanRemoval = true)
    private List<CartItem> cartItemList = new ArrayList<>();

    private double totalCartPrice = 0.0;

    public Cart(Long cartId, User user, List<CartItem> cartItemList, double totalCartPrice) {
        this.cartId = cartId;
        this.user = user;
        this.cartItemList = cartItemList;
        this.totalCartPrice = totalCartPrice;
    }

    public Cart() {
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public double getTotalCartPrice() {
        return totalCartPrice;
    }

    public void setTotalCartPrice(double totalCartPrice) {
        this.totalCartPrice = totalCartPrice;
    }
}
