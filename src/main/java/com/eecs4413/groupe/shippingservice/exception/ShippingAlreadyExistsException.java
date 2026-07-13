package com.eecs4413.groupe.shippingservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ShippingAlreadyExistsException extends RuntimeException {

    public ShippingAlreadyExistsException(UUID orderId) {
        super(String.format("Shipping information for order with id %s already exists", orderId));
    }
}
