package com.ecommerce.Rp_ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false )
    private Order order;

    @Enumerated(EnumType.STRING)
    @NotNull
    private PaymentStatus status;
    @Enumerated(EnumType.STRING)
    @NotNull
    private PaymentMethod paymentMethod;

    private String transactionId;
    @NotNull
    @Column(nullable = false)
    private Double amount;

    private LocalDateTime paymentTime;

    private String paymentGatewayPaymentId;
    private String paymentGatewayStatus;
    private String paymentGatewayResponseMessage;
    private String paymentGatewayName;

    @PrePersist
    private void prePersist(){
        this.paymentTime = LocalDateTime.now();
    }

    public Payment() {
    }

    public Payment(Long paymentId, String paymentGatewayPaymentId,
                   String paymentGatewayStatus, String paymentGatewayResponseMessage,
                   String paymentGatewayName) {
        this.paymentId = paymentId;
        this.paymentGatewayPaymentId = paymentGatewayPaymentId;
        this.paymentGatewayStatus = paymentGatewayStatus;
        this.paymentGatewayResponseMessage = paymentGatewayResponseMessage;
        this.paymentGatewayName = paymentGatewayName;
    }

    public Payment(Long paymentId, Order order, PaymentStatus status,
                   PaymentMethod paymentMethod, String transactionId,
                   Double amount, LocalDateTime paymentTime, String
                           paymentGatewayPaymentId, String paymentGatewayStatus,
                   String paymentGatewayResponseMessage, String paymentGatewayName) {
        this.paymentId = paymentId;
        this.order = order;
        this.status = status;
        this.paymentMethod = paymentMethod;
        this.transactionId = transactionId;
        this.amount = amount;
        this.paymentTime = paymentTime;
        this.paymentGatewayPaymentId = paymentGatewayPaymentId;
        this.paymentGatewayStatus = paymentGatewayStatus;
        this.paymentGatewayResponseMessage = paymentGatewayResponseMessage;
        this.paymentGatewayName = paymentGatewayName;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }


    public String getPaymentGatewayPaymentId() {
        return paymentGatewayPaymentId;
    }

    public void setPaymentGatewayPaymentId(String paymentGatewayPaymentId) {
        this.paymentGatewayPaymentId = paymentGatewayPaymentId;
    }

    public String getPaymentGatewayStatus() {
        return paymentGatewayStatus;
    }

    public void setPaymentGatewayStatus(String paymentGatewayStatus) {
        this.paymentGatewayStatus = paymentGatewayStatus;
    }

    public String getPaymentGatewayResponseMessage() {
        return paymentGatewayResponseMessage;
    }

    public void setPaymentGatewayResponseMessage(String paymentGatewayResponseMessage) {
        this.paymentGatewayResponseMessage = paymentGatewayResponseMessage;
    }

    public String getPaymentGatewayName() {
        return paymentGatewayName;
    }

    public void setPaymentGatewayName(String paymentGatewayName) {
        this.paymentGatewayName = paymentGatewayName;
    }
}

