package com.ecommerce.mapper;

import com.ecommerce.dto.OrdersDto;
import com.ecommerce.entity.Orders;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrdersMapperImpl implements OrdersMapper {
    @Override
    public OrdersDto toOrdersDto(Orders orders) {

        OrdersDto ordersDto = new OrdersDto();

        ordersDto.setUser(orders.getUserData());
        ordersDto.setProduct(orders.getProduct());
        ordersDto.setPurchaseDate(orders.getPurchaseDate());

        return ordersDto;
    }

    @Override
    public List<OrdersDto> toOrdersDtoList(List<Orders> ordersList) {

        List<OrdersDto> ordersDtoList = new ArrayList<>();

        for(Orders orders : ordersList) {
            ordersDtoList.add(toOrdersDto(orders));
        }

        return ordersDtoList;
    }
}
