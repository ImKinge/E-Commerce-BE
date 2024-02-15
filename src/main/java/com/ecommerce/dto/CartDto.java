package com.ecommerce.dto;

import com.ecommerce.entity.Product;
import com.ecommerce.entity.UserData;

public class CartDto {

    private Integer id;

    private Product product;

    private UserData userData;


    public CartDto () {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }
}
