package com.example.OrderItem.service;

import com.example.OrderItem.entity.OrderEntity;
import com.example.OrderItem.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<OrderEntity> getAllOrders() {
        return repository.findAll();
    }

    public OrderEntity getOrderById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public OrderEntity createOrder(OrderEntity order) {
        return repository.save(order);
    }

    public OrderEntity updateOrder(Long id, OrderEntity order) {
        Optional<OrderEntity> existing = repository.findById(id);
        if (existing.isPresent()) {
            OrderEntity o = existing.get();
            o.setItemName(order.getItemName());
            o.setPrice(order.getPrice());
            return repository.save(o);
        }
        return null;
    }

//    public OrderEntity updateOrder(Long id, OrderEntity order) {
//        return repository.findById(id)
//                .map(existing -> {
//                    existing.setItemName(order.getItemName());
//                    existing.setPrice(order.getPrice());
//                    return repository.save(existing);
//                })
//                .orElse(null);
//    }


    public void deleteOrder(Long id) {
        repository.deleteById(id);
    }

    public void deleteAllOrders() {
        repository.deleteAll();
    }

}
