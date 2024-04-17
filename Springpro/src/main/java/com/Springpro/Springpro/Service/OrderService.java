package com.Springpro.Springpro.Service;

import com.Springpro.Springpro.Model.entity.OrderModel;
import com.Springpro.Springpro.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderModel> getAllOrders() {
        return orderRepository.findAll();
    }

    public OrderModel getOrderById(Integer id) {
        Optional<OrderModel> orderOptional = orderRepository.findById(id);
        return orderOptional.orElse(new OrderModel());
    }

    public OrderModel createOrder(OrderModel order) {
        return orderRepository.save(order);
    }

    public OrderModel updateOrder(Integer id, OrderModel order) {
        Optional<OrderModel> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            order.setId(id);
            return orderRepository.save(order);
        } else {
            return new OrderModel();
        }
    }

    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }

    public OrderModel partiallyUpdateOrder(Integer id, OrderModel updatedOrder) {
        Optional<OrderModel> optionalExistingOrder = orderRepository.findById(id);
        if (optionalExistingOrder.isPresent()) {
            OrderModel existingOrder = optionalExistingOrder.get();

            if (updatedOrder.getOrderDate() != null) {
                existingOrder.setOrderDate(updatedOrder.getOrderDate());
            }
            if (updatedOrder.getCustomerId() != null) {
                existingOrder.setCustomerId(updatedOrder.getCustomerId());
            }
            if (updatedOrder.getProductId() != null) {
                existingOrder.setProductId(updatedOrder.getProductId());
            }
            if (updatedOrder.getTotalAmount() != null) {
                existingOrder.setTotalAmount(updatedOrder.getTotalAmount());
            }
            if (updatedOrder.getStatus() != null) {
                existingOrder.setStatus(updatedOrder.getStatus());
            }

            return orderRepository.save(existingOrder);
        } else {
            return new OrderModel();
        }
    }
}
