package com.ecommerce.service;

import com.ecommerce.dto.OrdersDto;
import com.ecommerce.entity.Orders;
import com.ecommerce.exception.ProductException;
import com.ecommerce.exception.ResultQueryException;
import com.ecommerce.exception.UserException;
import com.ecommerce.mapper.OrdersMapper;
import com.ecommerce.repository.CartRepository;
import com.ecommerce.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService{

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private OrdersMapper ordersMapper;


    /**
     * Metodo che mi permette di aggiungere i prodotti nel carrello all'interno degli ordini
     * Se la lista degli ordini non è vuota, allora la salvi e ripulisci il carrello
     * se la lista degli ordini è vuota, lanci un'eccezione poiché non permetto di effettuare un ordine con zero articoli
     *
     * @param ordersList
     * @param fiscalCode
     * @return
     * @throws ResultQueryException
     */
    @Override
    public List<Orders> addToOrders(List<Orders> ordersList, String fiscalCode) throws ResultQueryException {

        List<Orders> ordersListRes = new ArrayList<>();
        if(!ordersList.isEmpty()) {
            LocalDateTime localDateTime = LocalDateTime.now();

            for(Orders orders : ordersList) {
                orders.setPurchaseDate(localDateTime);
            }
            ordersListRes = ordersRepository.saveAll(ordersList);
            cartRepository.deleteAllByUserData(fiscalCode);
        } else {
            throw new ResultQueryException("Non puoi effettuare l'ordine con 0 articoli nel carrello");
        }

        return ordersListRes;
    }

    @Override
    public List<OrdersDto> findAllOrdersByUser(String fiscalCode) {

        List<Orders> ordersDtoList = ordersRepository.findAllByFiscalCode(fiscalCode);

        return ordersMapper.toOrdersDtoList(ordersDtoList);
    }
}
