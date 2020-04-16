package com.endurance.datajdbc.jdbc.RetailItem;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

// By default, it tries to map to RETAIL_ITEM
@Table("RetailItem")
public class RetailItem {
    private final @Id Long id;
    private final String title;
    private final String description;
    @Column("currentPrice")
    private final Integer currentPrice;

    public static RetailItem of(String title, String description, Integer currentPrice) {
        return new RetailItem(null, title, description, currentPrice);
    }

    public RetailItem(Long id, String title, String description, Integer currentPrice) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.currentPrice = currentPrice;
    }

    public RetailItem withId(Long id) {
        return new RetailItem(id, this.title, this.description, this.currentPrice);
    }

    public Long getId() {
        return id;
    }

    public Integer getCurrentPrice() {
        return currentPrice;
    }
}
