package com.eecs4413.groupe.shippingservice.model.response;

import com.eecs4413.groupe.shippingservice.model.entity.Shipping;
import com.eecs4413.groupe.shippingservice.model.enums.ShippingStatus;

import java.util.UUID;

public record ShippingResponse (
        UUID id,
        UUID orderId,
        String trackingNumber,
        String country,
        String postalCode,
        String province,
        String city,
        String address,
        String fullName,
        ShippingStatus shippingStatus
) {
    public static ShippingResponse from(Shipping shipping) {
        return new ShippingResponse(
                shipping.getId(),
                shipping.getOrderId(),
                shipping.getTrackingNumber(),
                shipping.getCountry(),
                shipping.getPostalCode(),
                shipping.getProvince(),
                shipping.getCity(),
                shipping.getAddress(),
                shipping.getFullName(),
                shipping.getShippingStatus()
        );
    }
}
