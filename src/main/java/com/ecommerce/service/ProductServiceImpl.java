package com.ecommerce.service;

import com.ecommerce.dto.ProductDto;
import com.ecommerce.entity.Product;
import com.ecommerce.exception.ProductException;
import com.ecommerce.mapper.ProductMapper;
import com.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductDto> findAllServiceProduct() {
        return productMapper.toProductDtoList(productRepository.findAll());
    }

    @Override
    public ProductDto getProductDetailsByProductId(Integer productId) throws ProductException {

        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductException("Nessun prodotto eistente con id: " + productId));
        return productMapper.toProductDto(product);
    }
}
