package com.ecommerce.repository;

import com.ecommerce.entity.Cart;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    @Query(value = "select i from Cart i where i.userData.fiscalCode=?1")
    List<Cart> findAllById(String fiscalCode);

    /*
    Qui abbiamo usato il @Param(), è uguale a quello sopra
    Funziona utilizzando il valore che mettiamo dentro le tonte e lo utilizziamo nella query
     */
    @Modifying
    @Transactional
    @Query(value = "delete from Cart where userData.fiscalCode= :fiscal")
    void deleteAllByUserData (@Param("fiscal") String fiscalCode);
}
