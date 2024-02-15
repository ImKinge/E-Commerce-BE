package com.ecommerce.repository;

import com.ecommerce.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

    @Query(value = "select i from Orders i  where i.userData.fiscalCode=?1")
    List<Orders> findAllByFiscalCode (String fiscalCode);
}
