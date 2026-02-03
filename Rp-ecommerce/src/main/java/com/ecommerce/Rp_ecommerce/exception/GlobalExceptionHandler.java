package com.ecommerce.Rp_ecommerce.exception;

import com.ecommerce.Rp_ecommerce.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice

public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String , String>> handleMethodArgumentException(MethodArgumentNotValidException e){
        Map<String , String> response = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(err ->
        {
            String field = ((FieldError)err).getField();
            String message = err.getDefaultMessage();
            response.put(field , message);
        });

        return new ResponseEntity<>(response , HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException e){
        String message = e.getMessage();
        ApiResponse body = new ApiResponse(
                "item that you are looking for  , Not found!!",
                false,
                HttpStatus.NOT_FOUND.value()

        );
        return ResponseEntity.
                status(HttpStatus.NOT_FOUND).body(body);
    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ApiException e){
        String message = e.getMessage();
        return new ResponseEntity<>(message , HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<Map<String , Object>> invalidSizeHandler(MaxUploadSizeExceededException e){
        Map<String , Object> response = new HashMap<>();
        response.put("status" , HttpStatus.BAD_REQUEST.value());
        response.put("message" , "file is too large , please upload file less than 2 MB");
        response.put("error" , "file size limit exceeded");
        return new ResponseEntity<>(response , HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyFoundException.class)
    public ResponseEntity<?> duplicateUserExceptionHandler(UserAlreadyFoundException e){
        Map<String , Object> response = new HashMap<>();
        response.put("status"  , HttpStatus.CONFLICT.value());
        response.put("message" , " User already found !!");
        response.put("error" , " conflict , please login instaed!!");
        return new ResponseEntity<>(response , HttpStatus.CONFLICT );
    }
}
