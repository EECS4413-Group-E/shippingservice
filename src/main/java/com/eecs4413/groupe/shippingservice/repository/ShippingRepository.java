package com.eecs4413.groupe.shippingservice.repository;

import com.eecs4413.groupe.shippingservice.model.entity.Shipping;
import com.eecs4413.groupe.shippingservice.model.enums.ShippingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ShippingRepository extends JpaRepository<Shipping, UUID> {
    boolean existsByTrackingNumber(String shippingNumber);

    boolean existsByOrderId(UUID orderId);

    Optional<Shipping> findByOrderId(UUID orderId);

    List<Shipping> findAllByShippingStatus(ShippingStatus shippingStatus);
}
