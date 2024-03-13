package com.ecommerce.mapper;

import com.ecommerce.dto.CartRequestDto;
import com.ecommerce.dto.OrdersDto;
import com.ecommerce.entity.Orders;

import java.util.List;

public interface OrdersMapper {

    Orders toOrders (CartRequestDto orderDto);

    OrdersDto toOrdersDto (Orders orders);
    List<OrdersDto> toOrderDtoList (List<Orders> ordersList);
}
