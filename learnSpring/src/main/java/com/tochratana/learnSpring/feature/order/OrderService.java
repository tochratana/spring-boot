package com.tochratana.learnSpring.feature.order;

import com.tochratana.learnSpring.feature.order.dto.CreateOrderRequest;
import com.tochratana.learnSpring.feature.order.dto.OrderResponse;

public interface OrderService {
    OrderResponse createOrder(CreateOrderRequest createOrderRequest);
}
