package com.ecommerce.repository;

import com.ecommerce.entity.Orders;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

    @Query(value = "select i from Orders i  where i.userData.fiscalCode=?1")
    List<Orders> findAllByFiscalCode (String fiscalCode);

    @Query(value = "SELECT p FROM Orders p ORDER BY p.purchaseDate DESC LIMIT 1")
    Orders getLastOrderByPurchaseDate ();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO orders_product (orders_id, product_id) VALUES (:orderId, :productId)", nativeQuery = true)
    void saveOrderWithProduct (@Param("orderId")Integer orderId, @Param("productId")Integer productId);
}
