package com.ecommerce.controller;

import com.ecommerce.dto.OrdersDto;
import com.ecommerce.dto.ResponseDto;
import com.ecommerce.entity.Orders;
import com.ecommerce.exception.ProductException;
import com.ecommerce.exception.ResultQueryException;
import com.ecommerce.exception.UserException;
import com.ecommerce.mapper.OrdersMapper;
import com.ecommerce.security.jwt.JWTGenerator;
import com.ecommerce.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:4200" , allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private JWTGenerator jwtGenerator;

    @Autowired
    private OrdersMapper ordersMapper;


    @PostMapping("/add-to-orders")
    public ResponseEntity<?> addProductToOrders (@RequestBody List<Orders> ordersList,
                                                                      @RequestHeader (HttpHeaders.AUTHORIZATION) String token) throws UserException, ProductException {

        String fiscalCode = jwtGenerator.getFiscalCodeFromJWT(token);

        try {
            List<OrdersDto> ordersDtoList = ordersMapper.toOrdersDtoList(ordersService.addToOrders(ordersList, fiscalCode));

            return new ResponseEntity<>(new ResponseDto<>(ordersDtoList, true), HttpStatus.OK);
        } catch (ResultQueryException ex) {
            return new ResponseEntity<>(new ResponseDto<>(ex.getMessage(), false), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/get-all-orders")
    public ResponseEntity<ResponseDto<List<OrdersDto>>> getAllOrdersByFiscalCode (@RequestHeader (HttpHeaders.AUTHORIZATION) String token) {

        String fiscalCode = jwtGenerator.getFiscalCodeFromJWT(token);

        List<OrdersDto> ordersDtoList = ordersService.findAllOrdersByUser(fiscalCode);

        return new ResponseEntity<>(new ResponseDto<>(ordersDtoList, true), HttpStatus.OK);
    }
}
