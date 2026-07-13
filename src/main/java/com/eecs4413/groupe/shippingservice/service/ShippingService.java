package com.eecs4413.groupe.shippingservice.service;

import com.eecs4413.groupe.shippingservice.exception.ShippingAlreadyExistsException;
import com.eecs4413.groupe.shippingservice.exception.ShippingNotFoundException;
import com.eecs4413.groupe.shippingservice.model.entity.Shipping;
import com.eecs4413.groupe.shippingservice.model.enums.ShippingStatus;
import com.eecs4413.groupe.shippingservice.model.request.ShippingRequest;
import com.eecs4413.groupe.shippingservice.repository.ShippingRepository;
import com.eecs4413.groupe.shippingservice.util.TrackingNumberGenerator;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ShippingService {

    private final ShippingRepository _shippingRepository;

    public ShippingService(ShippingRepository shippingRepository) {
        _shippingRepository = shippingRepository;
    }

    public Shipping createShippingDetails(@Valid ShippingRequest request) {
        if (_shippingRepository.existsByOrderId(request.orderId())) {
            throw new ShippingAlreadyExistsException(request.orderId());
        }

        Shipping shipping = new Shipping();

        shipping.setOrderId(request.orderId());
        shipping.setTrackingNumber(TrackingNumberGenerator.generate());
        shipping.setCountry(request.country());
        shipping.setPostalCode(request.postalCode());
        shipping.setProvince(request.province());
        shipping.setCity(request.city());
        shipping.setAddress(request.address());
        shipping.setFullName(request.fullName());
        shipping.setShippingStatus(ShippingStatus.PREPARING);

        return _shippingRepository.save(shipping);
    }

    public Shipping getShippingById(UUID id) {
        return _shippingRepository.findById(id)
                .orElseThrow(() -> new ShippingNotFoundException("id", id));
    }

    public Shipping getShippingByOrderId(UUID orderId) {
        return _shippingRepository
                .findByOrderId(orderId)
                .orElseThrow(() -> new ShippingNotFoundException("orderId", orderId));
    }
}
