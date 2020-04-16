package com.endurance.datajdbc.jdbc.Orders;

import com.endurance.datajdbc.jdbc.Customer.Customer;
import com.endurance.datajdbc.jdbc.RetailItem.RetailItem;
import com.endurance.datajdbc.repository.Customer.CustomerRepository;
import com.endurance.datajdbc.repository.Orders.OrdersRepository;
import com.endurance.datajdbc.repository.RetailItem.RetailItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJdbcTest
class OrdersTest {
    private final OrdersRepository ordersRepository;

    @Autowired
    public OrdersTest(OrdersRepository ordersRepository, CustomerRepository customerRepository,
                      RetailItemRepository retailItemRepository){
        this.ordersRepository = ordersRepository;
    }

    @Test
    public void createOrders() {
        // New order
        Orders orders = Orders.of(100L, "188 French Farm RD", 20);
        // Order item 1
        OrderItem orderItem1 = new OrderItem(20, 2L, 100);
        orders.addOrderItems(orderItem1);
        // Order item 2
        OrderItem orderItem2 = new OrderItem(10, 5L, 500);
        orders.addOrderItems(orderItem2);
        // persist new order
        Orders persistedOrders = ordersRepository.save(orders);
        assertNotNull(persistedOrders.getId());
        // Retrieve Orders from the repo
        Optional<Orders> optionalOrders = ordersRepository.findById(persistedOrders.getId());
        Orders orders1 = optionalOrders.get();
        assertNotNull(orders1, ()->"New order creation failed");
    }

    @Test
    public void deleteOrder() {
        // New order
        Orders orders = Orders.of(100L, "188 French Farm RD", 20);
        // Order item 1
        OrderItem orderItem1 = new OrderItem(20, 2L, 100);
        orders.addOrderItems(orderItem1);
        // Order item 2
        OrderItem orderItem2 = new OrderItem(10, 5L, 500);
        orders.addOrderItems(orderItem2);
        // persist new order
        Orders persistedOrders = ordersRepository.save(orders);
        assertNotNull(persistedOrders.getId());
        // delete the order
        ordersRepository.deleteById(persistedOrders.getId());
        // Retrieve Orders from the repo
        Optional<Orders> optionalOrders = ordersRepository.findById(persistedOrders.getId());
        assertTrue(optionalOrders.isEmpty(), ()->"Failed to delete orders");

    }

}