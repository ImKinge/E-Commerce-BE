package com.ecommerce.mapper;

import com.ecommerce.dto.ProductDto;
import com.ecommerce.entity.Product;

import java.util.List;

public interface ProductMapper {

    ProductDto toProductDto (Product product);

    List<ProductDto> toProductDtoList (List<Product> productList);
}
