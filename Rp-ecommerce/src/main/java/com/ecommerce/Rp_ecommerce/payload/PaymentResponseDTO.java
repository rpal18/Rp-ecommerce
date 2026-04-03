package com.ecommerce.Rp_ecommerce.payload;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentResponseDTO {

    private Long paymentId;

    private Long orderId;

    private String status;
    private String paymentMethod;

    private String transactionId;

    private BigDecimal amount;

    private LocalDateTime paymentTime;

    private String paymentGatewayPaymentId;
    private String paymentGatewayStatus;
    private String paymentGatewayResponseMessage;
    private String paymentGatewayName;

    public PaymentResponseDTO() {
    }

    public PaymentResponseDTO(Long paymentId, Long orderId, String status,
                              String paymentMethod, String transactionId,
                              BigDecimal amount, LocalDateTime paymentTime,
                              String paymentGatewayPaymentId,
                              String paymentGatewayStatus,
                              String paymentGatewayResponseMessage,
                              String paymentGatewayName) {
        this.paymentId = paymentId;
        this.orderId = orderId;
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

    // getters & setters

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(LocalDateTime paymentTime) {
        this.paymentTime = paymentTime;
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
