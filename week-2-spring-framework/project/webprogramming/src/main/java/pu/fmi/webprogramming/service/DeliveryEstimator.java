package pu.fmi.webprogramming.service;

import org.springframework.stereotype.Component;
import pu.fmi.webprogramming.model.Delivery;

import java.time.LocalDateTime;

@Component
public class DeliveryEstimator {

  public LocalDateTime estimateArrivalTime(Delivery delivery) {

    LocalDateTime createdAt = delivery.getCreatedAt();

    int daysToAdd;

    // Check if cities match
    if (delivery.getWarehouse().getCity()
            .equals(delivery.getCustomer().getCity())) {
      daysToAdd = 1;
    } else {
      daysToAdd = 3;
    }

    // Check if courier is assigned
    if (delivery.getCourier() == null) {
      daysToAdd += 2;
    }

    return createdAt.plusDays(daysToAdd);
  }
}
