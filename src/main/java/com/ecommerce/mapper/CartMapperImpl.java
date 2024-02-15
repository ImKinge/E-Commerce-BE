package com.ecommerce.mapper;

import com.ecommerce.dto.CartDto;
import com.ecommerce.entity.Cart;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CartMapperImpl implements CartMapper{
    @Override
    public CartDto toCartDto(Cart cart) {

        if(cart == null) {
            return null;
        }

        CartDto cartDto = new CartDto();

        cartDto.setId(cart.getId());
        cartDto.setUserData(cart.getUserData());
        cartDto.setProduct(cart.getProduct());

        return cartDto;
    }

    @Override
    public List<CartDto> toCartDtoList(List<Cart> cartList) {

        List<CartDto> cartDtoList = new ArrayList<>();

        for(Cart cart : cartList) {
            cartDtoList.add(toCartDto(cart));
        }

        return cartDtoList;
    }
}
