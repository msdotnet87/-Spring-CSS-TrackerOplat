package com.msi.panel.service;

import com.msi.panel.entity.Order;
import com.msi.panel.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Order_Service_Implem implements OrderService {

    OrderRepository orderRepository;

    public Order_Service_Implem(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> showAllOrders() {
        return orderRepository.showallOrders();
    }

    @Override
    public List<Order> showOrdersByCustomer(String customer) {
        return orderRepository.showByCustomer(customer);
    }
}
