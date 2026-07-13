package com.eecs4413.groupe.shippingservice.model.entity;

import com.eecs4413.groupe.shippingservice.model.enums.ShippingStatus;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "order_shipping")
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(nullable = false, updatable = false)
    private UUID orderId;

    @Column(name = "tracking_number", nullable = false, unique = true, updatable = false)
    private String trackingNumber;

    @Column(name = "country", nullable = false, updatable = false)
    private String country = "Canada";

    @Column(name = "postal_code", nullable = false, updatable = false)
    private String postalCode;

    @Column(name = "province", nullable = true, updatable = false)
    private String province;

    @Column(name = "city", nullable = false, updatable = false)
    private String city;

    @Column(name = "address", nullable = false, updatable = false)
    private String address;

    @Column(name = "full_name", nullable = false, updatable = false)
    private String fullName;

    @Enumerated(EnumType.STRING)
    @Column(name = "shipping_status", nullable = false)
    private ShippingStatus shippingStatus;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public ShippingStatus getShippingStatus() {
        return shippingStatus;
    }

    public void setShippingStatus(ShippingStatus shippingStatus) {
        this.shippingStatus = shippingStatus;
    }
}
