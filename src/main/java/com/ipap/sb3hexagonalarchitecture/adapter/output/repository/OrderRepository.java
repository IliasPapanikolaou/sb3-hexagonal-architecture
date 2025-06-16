package com.ipap.sb3hexagonalarchitecture.adapter.output.repository;

import com.ipap.sb3hexagonalarchitecture.adapter.output.entity.OrderEntity;
import com.ipap.sb3hexagonalarchitecture.domain.dto.FoodOrder;
import com.ipap.sb3hexagonalarchitecture.domain.port.output.OrderRepositoryPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class OrderRepository implements OrderRepositoryPort {

    private final MongoOrderRepository mongoOrderRepository;

    public OrderRepository(MongoOrderRepository mongoOrderRepository) {
        this.mongoOrderRepository = mongoOrderRepository;
    }

    @Override
    public void saveOrder(FoodOrder foodOrder) {
        log.debug("-- OUTPUT ADAPTER EXECUTED WITH OUTPUT PORT -- Saving order: {}", foodOrder);
        mongoOrderRepository.save(mapToEntity(foodOrder));
    }

    @Override
    public String findOrderById(String orderId) {
        log.debug("-- OUTPUT ADAPTER EXECUTED WITH OUTPUT PORT -- Finding order by ID: {}", orderId);
        return mongoOrderRepository.findById(orderId)
                .map(OrderEntity::getOrderId)
                .orElse("Order not found");
    }

    private static OrderEntity mapToEntity(FoodOrder foodOrder) {
        // Convert FoodOrder to OrderEntity
        return OrderEntity.builder()
                .orderId(foodOrder.orderId())
                .customerName(foodOrder.customerName())
                .restaurantName(foodOrder.restaurantName())
                .item(foodOrder.item())
                .status(foodOrder.status())
                .build();
    }

    private static FoodOrder mapToDomain(OrderEntity orderEntity) {
        // Convert OrderEntity to FoodOrder
        return new FoodOrder(
                orderEntity.getOrderId(),
                orderEntity.getCustomerName(),
                orderEntity.getRestaurantName(),
                orderEntity.getItem(),
                orderEntity.getStatus()
        );
    }
}
