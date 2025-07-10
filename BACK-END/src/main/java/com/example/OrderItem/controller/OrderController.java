package com.example.OrderItem.controller;

import com.example.OrderItem.entity.OrderEntity;
import com.example.OrderItem.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*") // Allow frontend to access this API
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    // Get all orders
    @GetMapping
    public List<OrderEntity> getAll() {
        return service.getAllOrders();
    }

    // Get order by ID
    @GetMapping("/{id}")
    public ResponseEntity<OrderEntity> getById(@PathVariable Long id) {
        OrderEntity order = service.getOrderById(id);
        return order != null ? ResponseEntity.ok(order) : ResponseEntity.notFound().build();
    }

    // Create a new order
    @PostMapping
    public OrderEntity create(@RequestBody OrderEntity order) {
        return service.createOrder(order);
    }

    // Update an existing order
    @PutMapping("/{id}")
    public ResponseEntity<OrderEntity> update(@PathVariable Long id, @RequestBody OrderEntity order) {
        return Optional.ofNullable(service.updateOrder(id, order))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete an order
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

    // Delete all orders
    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        service.deleteAllOrders();
        return ResponseEntity.noContent().build();
    }
}
