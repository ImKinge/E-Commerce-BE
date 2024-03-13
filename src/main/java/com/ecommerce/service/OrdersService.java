package com.ecommerce.service;

import com.ecommerce.dto.CartRequestDto;
import com.ecommerce.dto.OrdersDto;
import com.ecommerce.entity.Orders;
import com.ecommerce.exception.ProductException;
import com.ecommerce.exception.ResultQueryException;
import com.ecommerce.exception.UserException;

import java.util.List;
import java.util.Set;

public interface OrdersService {


    void addToOrders(CartRequestDto cartRequestDto, String fiscalCode) throws UserException, ProductException, ResultQueryException;

    //Set<OrdersDto> findAllOrdersByUser(String fiscalCode);

    List<OrdersDto> findAllByFiscalCode (String fiscalCode) throws ResultQueryException;
}
