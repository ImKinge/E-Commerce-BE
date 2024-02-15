package com.ecommerce.repository;

import com.ecommerce.entity.Favourites;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface FavouritesRepository extends JpaRepository<Favourites, Integer> {

    @Query(value = "select i from Favourites i where i.product.id=?1 and i.userData.fiscalCode=?2")
    Optional<Favourites> findByProductIdAndUser (Integer productId, String fiscalCode);

    @Query(value = "select i from Favourites i where i.userData.fiscalCode=?1")
    Set<Favourites> findAllById(String fiscalCode);

    /*
    Qui abbiamo usato il @Param(), è uguale a quello sopra
    Funziona utilizzando il valore che mettiamo dentro le tonte e lo utilizziamo nella query
     */
    @Modifying
    @Transactional
    @Query(value = "delete from Favourites where product.id = :productId")
    void deleteByProductId (@Param("productId") Integer productId);


}
