package com.eecs4413.groupe.shippingservice.job;

import com.eecs4413.groupe.shippingservice.model.entity.Shipping;
import com.eecs4413.groupe.shippingservice.model.enums.ShippingStatus;
import com.eecs4413.groupe.shippingservice.repository.ShippingRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.util.List;

@Component
public class UpdateShippingProgressJob {

    private final ShippingRepository _shippingRepository;

    private static final SecureRandom RANDOM = new SecureRandom();

    public UpdateShippingProgressJob(ShippingRepository shippingRepository) {
        _shippingRepository = shippingRepository;
    }

    @Scheduled(cron = "0 0 * * * *") // every hour
    @Transactional
    public void updateShippingProgress() {
        List<Shipping> shippingsInPreparation = _shippingRepository.findAllByShippingStatus(ShippingStatus.PREPARING);
        List<Shipping> shippedShippings = _shippingRepository.findAllByShippingStatus(ShippingStatus.SHIPPED);

        for (Shipping shipping : shippingsInPreparation) {
            boolean toProgress = RANDOM.nextInt(100) >= (100 - 50); // 50% chance of progress
            if (toProgress) {
                shipping.setShippingStatus(ShippingStatus.SHIPPED);
                _shippingRepository.save(shipping);
            }
        }

        for (Shipping shipping : shippedShippings) {
            boolean toProgress = RANDOM.nextInt(100) >= (100 - 15); // 15% chance of progress
            if (toProgress) {
                shipping.setShippingStatus(ShippingStatus.DELIVERED);
                _shippingRepository.save(shipping);
            }
        }
    }
}
