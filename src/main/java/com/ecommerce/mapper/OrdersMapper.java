package com.ecommerce.mapper;

import com.ecommerce.dto.OrdersDto;
import com.ecommerce.entity.Orders;

import java.util.List;

public interface OrdersMapper {

    OrdersDto toOrdersDto (Orders orders);

    List<OrdersDto> toOrdersDtoList (List<Orders> ordersList);
}
