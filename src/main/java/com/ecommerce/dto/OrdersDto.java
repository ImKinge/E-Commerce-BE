package com.ecommerce.dto;

import com.ecommerce.entity.Product;
import com.ecommerce.entity.UserData;


import java.time.LocalDateTime;

public class OrdersDto {

    private Integer id;
    private UserData userData;
    private Product product;
    private LocalDateTime purchaseDate;


    public OrdersDto () {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserData getUser() {
        return userData;
    }

    public void setUser(UserData userData) {
        this.userData = userData;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
