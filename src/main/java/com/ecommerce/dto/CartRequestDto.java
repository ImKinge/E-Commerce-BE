package com.ecommerce.dto;

import com.ecommerce.entity.Product;
import com.ecommerce.entity.UserData;


import java.util.List;

public class CartRequestDto {


    private UserData userData;
    private List<Product> productList;


    public CartRequestDto() {

    }


    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

}
