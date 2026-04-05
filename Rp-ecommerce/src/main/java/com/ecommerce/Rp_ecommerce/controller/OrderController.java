package com.ecommerce.Rp_ecommerce.controller;

import com.ecommerce.Rp_ecommerce.payload.OrderRequestDTO;
import com.ecommerce.Rp_ecommerce.payload.OrderResponseDTO;
import com.ecommerce.Rp_ecommerce.service.OrderOrchestratorService;
import com.ecommerce.Rp_ecommerce.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderController {

   private final OrderService orderService;
   private OrderOrchestratorService orderOrchestratorService;

   @Autowired
    public OrderController(OrderService orderService , OrderOrchestratorService orderOrchestratorService) {
         this.orderOrchestratorService = orderOrchestratorService;
        this.orderService = orderService;
    }

    @PostMapping("/orders")
    public ResponseEntity<OrderResponseDTO> orderProducts(@Valid @RequestBody OrderRequestDTO orderRequestDTO ){
        OrderResponseDTO response = orderOrchestratorService.processOrder(orderRequestDTO);
        return new ResponseEntity<>(response , HttpStatus.CREATED);
    }
}
