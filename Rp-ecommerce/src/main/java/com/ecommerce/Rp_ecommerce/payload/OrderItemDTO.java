package com.ecommerce.Rp_ecommerce.payload;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class OrderItemDTO {

    private Long orderItemId;

    private Long productId;

    @NotBlank
    private String productName;

    @NotNull
    @Min(1)
    private Integer quantity;

    @NotNull
    private Double priceAtPurchase;

    private Double totalPrice;

    private Double discount;
    private Double finalAmount;
    private Double shippingCharge;

    private String trackingId;
    private String deliveryPartner;

    private String notes;

    public OrderItemDTO() {
    }

    public OrderItemDTO(Long orderItemId, Long productId, String productName,
                        Integer quantity, Double priceAtPurchase, Double totalPrice,
                        Double discount, Double finalAmount, Double shippingCharge,
                        String trackingId, String deliveryPartner, String notes) {
        this.orderItemId = orderItemId;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.priceAtPurchase = priceAtPurchase;
        this.totalPrice = totalPrice;
        this.discount = discount;
        this.finalAmount = finalAmount;
        this.shippingCharge = shippingCharge;
        this.trackingId = trackingId;
        this.deliveryPartner = deliveryPartner;
        this.notes = notes;
    }

    // Getters & Setters

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPriceAtPurchase() {
        return priceAtPurchase;
    }

    public void setPriceAtPurchase(Double priceAtPurchase) {
        this.priceAtPurchase = priceAtPurchase;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(Double finalAmount) {
        this.finalAmount = finalAmount;
    }

    public Double getShippingCharge() {
        return shippingCharge;
    }

    public void setShippingCharge(Double shippingCharge) {
        this.shippingCharge = shippingCharge;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public String getDeliveryPartner() {
        return deliveryPartner;
    }

    public void setDeliveryPartner(String deliveryPartner) {
        this.deliveryPartner = deliveryPartner;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
