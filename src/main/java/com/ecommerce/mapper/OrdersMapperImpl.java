package com.ecommerce.mapper;

import com.ecommerce.dto.CartRequestDto;
import com.ecommerce.dto.OrdersDto;
import com.ecommerce.entity.Orders;
import com.ecommerce.entity.Product;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrdersMapperImpl implements OrdersMapper {

    @Override
    public Orders toOrders(CartRequestDto orderDto) {

        Orders orders = new Orders();
        LocalDateTime localDateTime = LocalDateTime.now();

        orders.setUserData(orderDto.getUserData());
        orders.setPurchaseDate(localDateTime);

        return orders;
    }

    @Override
    public OrdersDto toOrdersDto(Orders orders) {

        OrdersDto ordersDto = new OrdersDto();
        List<String> productName = new ArrayList<>();

        ordersDto.setOrderId(orders.getId());
        for(Product product : orders.getProductList()) {
            productName.add(product.getName());
        }
        ordersDto.setProductDtoList(productName);
        ordersDto.setPurchaseDate(orders.getPurchaseDate());

        return ordersDto;
    }

    @Override
    public List<OrdersDto> toOrderDtoList(List<Orders> ordersList) {

        List<OrdersDto> ordersDtoList = new ArrayList<>();

        for(Orders orders : ordersList) {
            ordersDtoList.add(toOrdersDto(orders));
        }
        return ordersDtoList;
    }

}
