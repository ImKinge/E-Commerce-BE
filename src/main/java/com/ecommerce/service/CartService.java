package com.ecommerce.service;

import com.ecommerce.dto.CartDto;
import com.ecommerce.entity.Cart;
import com.ecommerce.exception.ProductException;
import com.ecommerce.exception.UserException;

import java.util.List;

public interface CartService {

    Cart addToCart (Integer productId, String fiscalCode) throws ProductException, UserException;

    List<CartDto> findAllProductByUser (String fiscalCode);

    void removeToCart(Integer productId);
}
