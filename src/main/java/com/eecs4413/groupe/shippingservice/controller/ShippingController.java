package com.eecs4413.groupe.shippingservice.controller;

import com.eecs4413.groupe.shippingservice.model.entity.Shipping;
import com.eecs4413.groupe.shippingservice.model.request.ShippingRequest;
import com.eecs4413.groupe.shippingservice.model.response.ShippingResponse;
import com.eecs4413.groupe.shippingservice.service.ShippingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/shipping")
public class ShippingController {
    private final ShippingService _shippingService;

    public ShippingController(ShippingService shippingService) {
        _shippingService = shippingService;
    }

    @PostMapping()
    public ResponseEntity<ShippingResponse> createShippingDetails(@Valid @RequestBody ShippingRequest request) {
        Shipping shipping = _shippingService.createShippingDetails(request);
        return new ResponseEntity<>(ShippingResponse.from(shipping), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShippingResponse> getShippingById(@PathVariable UUID id) {
        Shipping shipping = _shippingService.getShippingById(id);
        return new ResponseEntity<>(ShippingResponse.from(shipping), HttpStatus.OK);
    }

    @PostMapping("/batch")
    public ResponseEntity<List<ShippingResponse>> getShippingDetailsBatch(@RequestBody List<UUID> ids){

        List<Shipping> shippings = new ArrayList<>();
        for(UUID id : ids){
            shippings.add(_shippingService.getShippingById(id));
        }
        return new ResponseEntity<>(shippings.stream().map(ShippingResponse::from).toList(), HttpStatus.OK);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<ShippingResponse> getShippingByOrderId(@PathVariable UUID orderId) {
        Shipping shipping = _shippingService.getShippingByOrderId(orderId);
        return new ResponseEntity<>(ShippingResponse.from(shipping), HttpStatus.OK);
    }
}
