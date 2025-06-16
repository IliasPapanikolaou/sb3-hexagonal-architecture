package com.ipap.sb3hexagonalarchitecture.config;

import com.ipap.sb3hexagonalarchitecture.domain.port.output.OrderRepositoryPort;
import com.ipap.sb3hexagonalarchitecture.domain.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfig {

    @Bean
    public OrderService orderService(OrderRepositoryPort orderRepository) {
        return new OrderService(orderRepository);
    }
}
