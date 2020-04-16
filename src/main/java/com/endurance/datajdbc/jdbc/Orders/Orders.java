package com.endurance.datajdbc.jdbc.Orders;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.sql.In;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Orders {
    private final @Id Long id;
    @Column("Customer")
    private final Long customerId;
    @Column("shippingAddress")
    private final String shippingAddress;
    @Column("shippingCost")
    private final Integer shippingCost;
    private List<OrderItem> orderItems = new ArrayList<>();

    public static Orders of(Long customerId, String shippingAddress, Integer shippingCost) {
        return new Orders(null, customerId, shippingAddress, shippingCost);
    }

    public Orders(Long id, Long customerId, String shippingAddress, Integer shippingCost) {
        this.id = id;
        this.customerId = customerId;
        this.shippingAddress = shippingAddress;
        this.shippingCost = shippingCost;
    }

    public Orders withId(Long id) {
        return new Orders(id, this.customerId, this.shippingAddress, this.shippingCost);
    }

    public void addOrderItems(OrderItem orderItem) {
        this.orderItems.add(orderItem);
    }

    public Long getId() {
        return id;
    }
}
