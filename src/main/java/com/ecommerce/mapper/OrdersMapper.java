package com.ecommerce.mapper;

import com.ecommerce.dto.CartRequestDto;
import com.ecommerce.entity.Orders;

import java.util.List;

public interface OrdersMapper {

    CartRequestDto toOrdersDto (Orders orders);

    Orders toOrders (CartRequestDto orderDto);

    List<CartRequestDto> toOrdersDtoList (List<Orders> ordersList);
}
