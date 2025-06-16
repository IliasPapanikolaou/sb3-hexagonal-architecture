package com.ipap.sb3hexagonalarchitecture.domain.port.input;

import com.ipap.sb3hexagonalarchitecture.domain.dto.FoodOrder;

public interface PlaceOrderUseCase {

    void placeOrder(FoodOrder foodOrder);
}
