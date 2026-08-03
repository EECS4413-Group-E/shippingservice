package com.eecs4413.groupe.shippingservice.model.request;

import com.eecs4413.groupe.shippingservice.model.enums.Province;

import java.util.UUID;

public record ShippingRequest (
        UUID orderId,
        String country,
        String postalCode,
        Province province,
        String city,
        String address,
        String fullName
) {}
