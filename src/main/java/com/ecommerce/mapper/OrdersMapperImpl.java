package com.ecommerce.mapper;

import com.ecommerce.dto.CartRequestDto;
import com.ecommerce.entity.Orders;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrdersMapperImpl implements OrdersMapper {
    @Override
    public CartRequestDto toOrdersDto(Orders orders) {

        CartRequestDto cartRequestDto = new CartRequestDto();

        cartRequestDto.setUserData(orders.getUserData());
        cartRequestDto.setProductList(orders.getProductList());

        return cartRequestDto;
    }

    @Override
    public Orders toOrders(CartRequestDto orderDto) {

        Orders orders = new Orders();
        LocalDateTime localDateTime = LocalDateTime.now();

        orders.setUserData(orderDto.getUserData());
        orders.setPurchaseDate(localDateTime);

        return orders;
    }


    @Override
    public List<CartRequestDto> toOrdersDtoList(List<Orders> ordersList) {

        List<CartRequestDto> cartRequestDtoList = new ArrayList<>();

        for(Orders orders : ordersList) {
            cartRequestDtoList.add(toOrdersDto(orders));
        }

        return cartRequestDtoList;
    }
}
