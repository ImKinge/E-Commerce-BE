package com.ecommerce.service;

import com.ecommerce.dto.OrdersDto;
import com.ecommerce.entity.Orders;
import com.ecommerce.exception.ProductException;
import com.ecommerce.exception.UserException;

import java.util.List;

public interface OrdersService {


    List<Orders> addToOrders(List<Orders> ordersList, String fiscalCode) throws UserException, ProductException;

    List<OrdersDto> findAllOrdersByUser(String fiscalCode);
}
