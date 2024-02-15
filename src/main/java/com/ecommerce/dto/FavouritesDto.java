package com.ecommerce.dto;

import com.ecommerce.entity.Product;
import com.ecommerce.entity.UserData;

public class FavouritesDto {

    private Integer id;

    private UserData userData;

    private Product product;


    public FavouritesDto () {

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
}
