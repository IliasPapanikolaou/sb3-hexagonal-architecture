package com.ipap.sb3hexagonalarchitecture.domain.port.output;

import com.ipap.sb3hexagonalarchitecture.domain.dto.FoodOrder;

public interface OrderRepositoryPort {

    void saveOrder(FoodOrder foodOrder);
    String findOrderById(String orderId);
}
