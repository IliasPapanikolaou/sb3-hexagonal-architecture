package com.ipap.sb3hexagonalarchitecture.domain.service;

import com.ipap.sb3hexagonalarchitecture.domain.dto.FoodOrder;
import com.ipap.sb3hexagonalarchitecture.domain.port.input.PlaceOrderUseCase;
import com.ipap.sb3hexagonalarchitecture.domain.port.input.TrackOrderUseCase;
import com.ipap.sb3hexagonalarchitecture.domain.port.output.OrderRepositoryPort;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public class OrderService implements PlaceOrderUseCase, TrackOrderUseCase {

    private final OrderRepositoryPort orderRepositoryPort;

    public OrderService(OrderRepositoryPort orderRepositoryPort) {
        this.orderRepositoryPort = orderRepositoryPort;
    }

    @Override
    public void placeOrder(FoodOrder order) {
        FoodOrder foodOrder = new FoodOrder(
                UUID.randomUUID().toString(),
                order.customerName(),
                order.restaurantName(),
                order.item(),
                "ORDER_PLACED"
        );
        log.debug("-- CORE EXECUTED WITH INPUT PORT -- Placing order: {}", foodOrder);
        orderRepositoryPort.saveOrder(foodOrder);
    }

    @Override
    public String trackOrder(String orderId) {
        log.debug("-- CORE EXECUTED WITH INPUT PORT -- Tracking order with ID: {}", orderId);
        return orderRepositoryPort.findOrderById(orderId);
    }
}
