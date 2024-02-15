package com.ecommerce.mapper;

import com.ecommerce.ImageUtils.ImageUtils;
import com.ecommerce.dto.ProductDto;
import com.ecommerce.entity.Product;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;

@Component
public class ProductMapperImpl implements ProductMapper{

    @Override
    public ProductDto toProductDto(Product product) {

        if(product == null) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId(product.getId());
        productDto.setCategory(product.getCategory());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setDescription(product.getDescription());
        try {
            productDto.setPhoto(ImageUtils.decompressImage(product.getPhoto()));
        } catch (DataFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return productDto;
    }

    @Override
    public List<ProductDto> toProductDtoList(List<Product> productList) {

        List<ProductDto> productDtoList = new ArrayList<>();

        for(Product product : productList) {
            productDtoList.add(toProductDto(product));
        }

        return productDtoList;
    }
}
