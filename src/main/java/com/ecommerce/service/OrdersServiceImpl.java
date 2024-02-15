package com.ecommerce.service;

import com.ecommerce.dto.OrdersDto;
import com.ecommerce.entity.Orders;
import com.ecommerce.exception.ProductException;
import com.ecommerce.exception.UserException;
import com.ecommerce.mapper.OrdersMapper;
import com.ecommerce.repository.CartRepository;
import com.ecommerce.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService{

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public List<Orders> addToOrders(List<Orders> ordersList, String fiscalCode) {

        LocalDateTime localDateTime = LocalDateTime.now();

        for(Orders orders : ordersList) {
            orders.setPurchaseDate(localDateTime);
        }
        List<Orders> ordersListRes = ordersRepository.saveAll(ordersList);

        if(!ordersList.isEmpty()) {
            cartRepository.deleteAllByUserData(fiscalCode);
        }

        return ordersListRes;
    }

    @Override
    public List<OrdersDto> findAllOrdersByUser(String fiscalCode) {

        List<Orders> ordersDtoList = ordersRepository.findAllByFiscalCode(fiscalCode);

        return ordersMapper.toOrdersDtoList(ordersDtoList);
    }
}
