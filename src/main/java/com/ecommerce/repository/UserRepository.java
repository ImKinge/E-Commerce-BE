package com.ecommerce.repository;

import com.ecommerce.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserData, Integer> {

    Optional<UserData> findByFiscalCode (String fiscalCode);

    Optional<UserData> findByUserName (String username);

    Boolean existsByUserName(String userName);


}
