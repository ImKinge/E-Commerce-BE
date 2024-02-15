package com.ecommerce.controller;

import com.ecommerce.dto.CartDto;
import com.ecommerce.dto.ResponseDto;
import com.ecommerce.exception.ProductException;
import com.ecommerce.exception.UserException;
import com.ecommerce.mapper.CartMapper;
import com.ecommerce.security.jwt.JWTGenerator;
import com.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:4200" , allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private JWTGenerator jwtGenerator;

    @Autowired
    private CartMapper cartMapper;


    @GetMapping("/add-to-cart")
    public ResponseEntity<ResponseDto<CartDto>> addProductToCart (@RequestParam Integer productId,
                                                                  @RequestHeader (HttpHeaders.AUTHORIZATION) String token) throws UserException, ProductException {

        String fiscalCode = jwtGenerator.getFiscalCodeFromJWT(token);
        CartDto cartDto = cartMapper.toCartDto(cartService.addToCart(productId, fiscalCode));

        return new ResponseEntity<>(new ResponseDto<>(cartDto, true), HttpStatus.OK);
    }

    @DeleteMapping("/delete-to-cart")
    public ResponseEntity<ResponseDto<String>> removeItemToCart (@RequestParam Integer cartItemId) {

        cartService.removeToCart(cartItemId);

        return new ResponseEntity<>(new ResponseDto<>("Rimozione avvenuta con successo!", true), HttpStatus.OK);
    }

    @GetMapping(value = "/get-cart-details")
    public ResponseEntity<ResponseDto<List<CartDto>>> getCartDetails (@RequestHeader (HttpHeaders.AUTHORIZATION) String token) {

        String fiscalCode = jwtGenerator.getFiscalCodeFromJWT(token);

        List<CartDto> cartDtoList = cartService.findAllProductByUser(fiscalCode);

        return new ResponseEntity<>(new ResponseDto<>(cartDtoList, true), HttpStatus.OK);
    }
}
