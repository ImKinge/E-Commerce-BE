package com.ecommerce.service;

import com.ecommerce.dto.OrdersDto;
import com.ecommerce.entity.Orders;
import com.ecommerce.exception.ProductException;
import com.ecommerce.exception.ResultQueryException;
import com.ecommerce.exception.UserException;

import java.util.List;

public interface OrdersService {


    List<Orders> addToOrders(List<Orders> ordersList, String fiscalCode) throws UserException, ProductException, ResultQueryException;

    List<OrdersDto> findAllOrdersByUser(String fiscalCode);
}
