package com.ecommerce.service;

import com.ecommerce.dto.CartRequestDto;
import com.ecommerce.dto.OrdersDto;
import com.ecommerce.entity.Orders;
import com.ecommerce.entity.Product;
import com.ecommerce.exception.ResultQueryException;
import com.ecommerce.mapper.OrdersMapper;
import com.ecommerce.repository.CartRepository;
import com.ecommerce.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
     * @param cartRequestDto
     * @param fiscalCode
     * @return
     * @throws ResultQueryException
     */
    @Override
    public void addToOrders(CartRequestDto cartRequestDto, String fiscalCode) throws ResultQueryException {

        List<Product> productList = cartRequestDto.getProductList();

        if(!cartRequestDto.getProductList().isEmpty()) {

            ordersRepository.save(ordersMapper.toOrders(cartRequestDto));

            //Prendo l'ultimo ordine salvato
            Orders orders = ordersRepository.getLastOrderByPurchaseDate();

            //Costruisco l'oggetto da salvare nella tabella orders_product
            Integer orderId = orders.getId();
            List<Integer> productIds = productList.stream()
                    .map(Product::getId)
                    .toList();

            /*
            salvo l'id del prodotto dentro la tabella orders_product,
            scorrendo la lista mappata in precedenza
            faccio un salvataggio per ogni record di prodotti che ho acquistato
             */
            for(Integer id : productIds) {
                ordersRepository.saveOrderWithProduct(orderId, id);
            }

            //cancella il carrello
            cartRepository.deleteAllByUserData(fiscalCode);
        } else {
            throw new ResultQueryException("Non puoi effettuare l'ordine con 0 articoli nel carrello");
        }
    }

    @Override
    public List<CartRequestDto> findAllOrdersByUser(String fiscalCode) {

        List<Orders> ordersDtoList = ordersRepository.findAllByFiscalCode(fiscalCode);

        return ordersMapper.toOrdersDtoList(ordersDtoList);
    }
}
