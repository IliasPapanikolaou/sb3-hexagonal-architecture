package com.ipap.sb3hexagonalarchitecture.adapter.output.repository;

import com.ipap.sb3hexagonalarchitecture.adapter.output.entity.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoOrderRepository extends MongoRepository<OrderEntity, String> {
}
