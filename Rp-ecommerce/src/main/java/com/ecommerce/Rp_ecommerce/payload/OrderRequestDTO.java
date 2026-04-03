package com.ecommerce.Rp_ecommerce.payload;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class OrderRequestDTO {

    @Valid
    @NotEmpty(message = "Order should contain at least one item")
    private List<OrderItemDTO> items;
    @NotNull(message = "Address Id should not be null")
    private Long addressId;

    public OrderRequestDTO() {
    }

    public OrderRequestDTO(List<OrderItemDTO> items, Long addressId) {
        this.items = items;
        this.addressId = addressId;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }
}