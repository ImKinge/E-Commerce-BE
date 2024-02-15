package com.ecommerce.service;

import com.ecommerce.dto.CartDto;
import com.ecommerce.entity.Cart;
import com.ecommerce.entity.Product;
import com.ecommerce.entity.UserData;
import com.ecommerce.exception.ProductException;
import com.ecommerce.exception.UserException;
import com.ecommerce.mapper.CartMapper;
import com.ecommerce.repository.CartRepository;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartMapper cartMapper;

    @Override
    public Cart addToCart(Integer productId, String fiscalCode) throws ProductException, UserException {

        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductException("Prodotto con id: " + productId + "inesistente!"));
        UserData userData = userRepository.findByFiscalCode(fiscalCode).orElseThrow(() -> new UserException("Nessun utente trovato con codice fiscale: " + fiscalCode));

        Cart cart = new Cart (product, userData);


        return cartRepository.save(cart);
    }

    @Override
    public List<CartDto> findAllProductByUser(String fiscalCode) {
        return cartMapper.toCartDtoList(cartRepository.findAllById(fiscalCode));
    }

    @Override
    public void removeToCart(Integer productId) {
        cartRepository.deleteById(productId);
    }
}
