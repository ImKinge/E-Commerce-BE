package com.ecommerce.dto;

import com.ecommerce.entity.Orders;
import com.ecommerce.entity.Product;

import java.util.List;

public class OrdersDto {

    private Orders ordersList;

    private List<Product> productList;


    public OrdersDto() {
    }


    public Orders getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(Orders ordersList) {
        this.ordersList = ordersList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
