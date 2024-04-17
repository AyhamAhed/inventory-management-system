package com.Springpro.Springpro.Controller;

import com.Springpro.Springpro.Model.entity.OrderModel;
import com.Springpro.Springpro.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    public ResponseEntity<List<OrderModel>> getAllOrders() {
        List<OrderModel> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/ById")
    public ResponseEntity<OrderModel> getOrderById(@RequestParam Integer id) {
        OrderModel order = orderService.getOrderById(id);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<OrderModel> createOrder(@RequestBody OrderModel order) {
        OrderModel createdOrder = orderService.createOrder(order);
        return ResponseEntity.ok(createdOrder);
    }

    @PutMapping("/updateById")
    public ResponseEntity<OrderModel> updateOrder(@RequestParam Integer id, @RequestBody OrderModel order) {
        OrderModel updatedOrder = orderService.updateOrder(id, order);
        if (updatedOrder != null) {
            return ResponseEntity.ok(updatedOrder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/DeleteOrder")
    public ResponseEntity<Void> deleteOrder(@RequestParam Integer id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/partiallyUpdatedOrder")
    public ResponseEntity<OrderModel> partiallyUpdateOrder(@RequestParam Integer id, @RequestBody OrderModel orderUpdates) {
        OrderModel updatedOrder = orderService.partiallyUpdateOrder(id, orderUpdates);
        if (updatedOrder != null) {
            return ResponseEntity.ok(updatedOrder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
