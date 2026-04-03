package com.ecommerce.Rp_ecommerce.payload;

import java.math.BigDecimal;

public class CartItemDTO {
    private Long cartItemId;
    private CartDTO cart;
    private ProductDTO productDTO;
    private Integer quantity;
    private BigDecimal discount;
    private BigDecimal productPrice;

    public CartItemDTO(Long cartItemId, CartDTO cart, ProductDTO productDTO, Integer quantity, BigDecimal discount, BigDecimal productPrice) {
        this.cartItemId = cartItemId;
        this.cart = cart;
        this.productDTO = productDTO;
        this.quantity = quantity;
        this.discount = discount;
        this.productPrice = productPrice;
    }

    public CartItemDTO() {
    }

    public Long getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Long cartItemId) {
        this.cartItemId = cartItemId;
    }

    public CartDTO getCart() {
        return cart;
    }

    public void setCart(CartDTO cart) {
        this.cart = cart;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }
}
