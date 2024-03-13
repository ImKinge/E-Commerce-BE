package com.ecommerce.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrdersDto {

    private Integer orderId;

    private List<String> productDtoList = new ArrayList<>();

    private LocalDateTime purchaseDate;


    public OrdersDto() {
    }

    public OrdersDto(Integer orderId, LocalDateTime purchaseDate) {
        this.orderId = orderId;
        this.purchaseDate = purchaseDate;
    }

    public OrdersDto(Integer orderId, List<String> productDtoList, LocalDateTime purchaseDate) {
        this.orderId = orderId;
        this.productDtoList = productDtoList;
        this.purchaseDate = purchaseDate;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public List<String> getProductDtoList() {
        return productDtoList;
    }

    public void setProductDtoList(List<String> productDtoList) {
        this.productDtoList = productDtoList;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
