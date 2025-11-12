package com.gopassa.retailer_service.domain.exceptions;

public class DuplicatedRecord extends RuntimeException{
    public DuplicatedRecord(String message){
        super(message);
    }
}
