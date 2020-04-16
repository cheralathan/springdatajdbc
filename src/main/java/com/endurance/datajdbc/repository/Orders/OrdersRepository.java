package com.endurance.datajdbc.repository.Orders;

import com.endurance.datajdbc.jdbc.Orders.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Orders, Long> {
}
