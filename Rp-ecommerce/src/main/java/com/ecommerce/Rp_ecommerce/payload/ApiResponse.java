package com.ecommerce.Rp_ecommerce.payload;

public class ApiResponse {
    private String message;
    private boolean status;

    private Integer statusCode ;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ApiResponse(String message, boolean status , Integer statusCode) {
        this.message = message;
        this.status = status;
        this.statusCode = statusCode;
    }

    public ApiResponse() {
    }
}
