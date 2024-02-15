package com.ecommerce.mapper;

import com.ecommerce.dto.CartDto;
import com.ecommerce.entity.Cart;

import java.util.List;

public interface CartMapper {

    CartDto toCartDto (Cart cart);

    List<CartDto> toCartDtoList (List<Cart> cartList);
}
