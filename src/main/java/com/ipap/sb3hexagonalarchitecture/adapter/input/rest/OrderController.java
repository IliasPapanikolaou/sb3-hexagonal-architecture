package com.ipap.sb3hexagonalarchitecture.adapter.input.rest;

import com.ipap.sb3hexagonalarchitecture.domain.dto.FoodOrder;
import com.ipap.sb3hexagonalarchitecture.domain.port.input.PlaceOrderUseCase;
import com.ipap.sb3hexagonalarchitecture.domain.port.input.TrackOrderUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final PlaceOrderUseCase placeOrderUseCase;
    private final TrackOrderUseCase trackOrderUseCase;

    public OrderController(PlaceOrderUseCase placeOrderUseCase, TrackOrderUseCase trackOrderUseCase) {
        this.placeOrderUseCase = placeOrderUseCase;
        this.trackOrderUseCase = trackOrderUseCase;
    }

    // Define endpoints for placing and tracking orders here
    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody FoodOrder order) {
        log.debug("-- INPUT ADAPTER EXECUTED -- Order placed: {}", order);
        placeOrderUseCase.placeOrder(order);

        return ResponseEntity.ok("Order placed successfully");
    }

    @GetMapping("/track/{orderId}")
    public ResponseEntity<String> trackOrder(@PathVariable String orderId) {
        log.debug("-- INPUT ADAPTER EXECUTED -- Order tracked");
        trackOrderUseCase.trackOrder(orderId);

        return ResponseEntity.ok("Status for order " + orderId + " tracked successfully");
    }
}
