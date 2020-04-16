package com.endurance.datajdbc.jdbc.Orders;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("OrderItem")
public class OrderItem {
    private final @Id  Integer quantity;
    @Column("retailItem_id")
    private final Long retailItem; // Refer to RetailItem Aggregate
    private final Integer price;

    public OrderItem(Integer quantity, Long retailItem, Integer price) {
        this.quantity = quantity;
        this.retailItem = retailItem;
        this.price = price;
    }
}
