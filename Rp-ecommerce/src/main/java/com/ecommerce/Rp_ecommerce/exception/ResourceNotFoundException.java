package com.ecommerce.Rp_ecommerce.exception;
/*
custom Exception handling class
 */
public class ResourceNotFoundException extends RuntimeException{
    private String resourceName;
    private String field;
    private String fieldName;
    private Long fieldId;

    public ResourceNotFoundException( String resourceName, String field, String fieldName) {
        /*
        here we are using String formatter
         */
        super(String.format("%s not found with %s : %s " , resourceName , field , fieldName));
        this.resourceName = resourceName;
        this.field = field;
        this.fieldName = fieldName;
    }

    public ResourceNotFoundException(String resourceName, String field, Long fieldId) {
        super(String.format("%s not found with %d : %s" , resourceName, fieldId,field));
        this.resourceName = resourceName;
        this.field = field;
        this.fieldId = fieldId;
    }
}
