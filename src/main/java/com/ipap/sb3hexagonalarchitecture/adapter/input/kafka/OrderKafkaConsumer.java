package com.ipap.sb3hexagonalarchitecture.adapter.input.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ipap.sb3hexagonalarchitecture.domain.dto.FoodOrder;
import com.ipap.sb3hexagonalarchitecture.domain.port.input.PlaceOrderUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderKafkaConsumer {

    private final PlaceOrderUseCase placeOrderUseCase;

    public OrderKafkaConsumer(PlaceOrderUseCase placeOrderUseCase) {
        this.placeOrderUseCase = placeOrderUseCase;
    }

    @KafkaListener(topics = "food-orders", groupId = "order-group")
    public void consume(String message) {
        ObjectMapper objectMapper = new ObjectMapper();
        FoodOrder foodOrder = objectMapper.convertValue(message, FoodOrder.class);
        log.debug("-- INPUT ADAPTER EXECUTED -- Order placed: {}", foodOrder.toString());
        placeOrderUseCase.placeOrder(foodOrder);
    }
}
