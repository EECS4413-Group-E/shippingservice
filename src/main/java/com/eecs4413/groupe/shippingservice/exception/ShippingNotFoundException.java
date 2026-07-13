package com.eecs4413.groupe.shippingservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ShippingNotFoundException extends RuntimeException {

    public ShippingNotFoundException(String message){
        super(message);
    }

    public ShippingNotFoundException(String idType, UUID id) {
        if (idType.equals("id")){
            throw new ShippingNotFoundException(String.format("Shipping with id %s not found", id));
        }
        else if (idType.equals("orderId")){
            throw new ShippingNotFoundException(String.format("Shipping for order with id %s not found", id));
        }
        throw new ShippingNotFoundException("Shipping not found");

    }
}
