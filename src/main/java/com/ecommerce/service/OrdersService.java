package com.ecommerce.service;

import com.ecommerce.dto.CartRequestDto;
import com.ecommerce.exception.ProductException;
import com.ecommerce.exception.ResultQueryException;
import com.ecommerce.exception.UserException;

import java.util.List;

public interface OrdersService {


    void addToOrders(CartRequestDto cartRequestDto, String fiscalCode) throws UserException, ProductException, ResultQueryException;

    List<CartRequestDto> findAllOrdersByUser(String fiscalCode);
}
