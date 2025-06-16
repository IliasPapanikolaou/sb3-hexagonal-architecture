package com.ipap.sb3hexagonalarchitecture.domain.dto;

public record FoodOrder(
        String orderId,
        String customerName,
        String restaurantName,
        String item,
        String status
) {
}
