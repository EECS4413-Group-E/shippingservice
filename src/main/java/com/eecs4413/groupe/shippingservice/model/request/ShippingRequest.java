package com.eecs4413.groupe.shippingservice.model.request;

import java.util.UUID;

public record ShippingRequest (
        UUID orderId,
        String country,
        String postalCode,
        String province,
        String city,
        String address,
        String fullName
) {}
