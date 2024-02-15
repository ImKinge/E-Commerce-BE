package com.ecommerce.service;

import com.ecommerce.dto.ProductDto;
import com.ecommerce.exception.ProductException;

import java.util.List;

public interface ProductService {

    List<ProductDto> findAllServiceProduct ();

    ProductDto getProductDetailsByProductId(Integer productId) throws ProductException;
}
