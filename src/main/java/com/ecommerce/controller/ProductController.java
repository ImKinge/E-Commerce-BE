package com.ecommerce.controller;

import com.ecommerce.dto.ProductDto;
import com.ecommerce.dto.ResponseDto;
import com.ecommerce.exception.ProductException;
import com.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:4200" , allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/find-all-product")
    public ResponseEntity<ResponseDto<List<ProductDto>>> findAllProduct () {

        List<ProductDto> productDtoList = productService.findAllServiceProduct();
        return new ResponseEntity<>(new ResponseDto<>(productDtoList, true), HttpStatus.OK);
    }

    @GetMapping("/find-by-product-id")
    public ResponseEntity<ResponseDto<ProductDto>> getProductDetailsByProductId (@RequestParam Integer productId) throws ProductException {

        ProductDto productDto = productService.getProductDetailsByProductId(productId);

        return new ResponseEntity<>(new ResponseDto<>(productDto, true), HttpStatus.OK);
    }
}
