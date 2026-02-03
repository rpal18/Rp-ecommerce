package com.ecommerce.Rp_ecommerce.exception;

public class UserAlreadyFoundException extends RuntimeException{

    public UserAlreadyFoundException(String message){
        super(message);
    }
}
