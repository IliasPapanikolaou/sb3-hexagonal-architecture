package com.ipap.sb3hexagonalarchitecture.adapter.output.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "orders")
public class OrderEntity {
    @Id
    private String orderId;
    private String customerName;
    private String restaurantName;
    private String item;
    private String status;
}
