package com.brizy.io.web.kiwi.tcms.service;


import com.brizy.io.web.kiwi.tcms.dto.request.product.CreateProductDto;
import com.brizy.io.web.kiwi.tcms.dto.request.product.CreateProductRequestDto;
import com.brizy.io.web.kiwi.tcms.dto.request.product.ProductByNameDto;
import com.brizy.io.web.kiwi.tcms.dto.request.product.ProductByNameRequestDto;
import com.brizy.io.web.kiwi.tcms.dto.response.product.CreateProductResponseDto;
import com.brizy.io.web.kiwi.tcms.dto.response.product.ProductDto;
import com.brizy.io.web.kiwi.tcms.dto.response.product.ProductResponseDto;
import com.brizy.io.web.kiwi.tcms.properties.api.AbstractProperty;
import com.brizy.io.web.kiwi.tcms.properties.api.KiwiTcmsApiProperties;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Service
public class ProductService extends AbstractService {

    AbstractProperty productProperties;

    @Autowired
    public ProductService(RestTemplate restTemplate, KiwiTcmsApiProperties apiProperties) {
        super(restTemplate);
        this.productProperties = apiProperties.getProduct();
    }

    public ProductDto getProductByName(String productName) {
        List<ProductByNameDto> params = List.of(ProductByNameDto.builder().name(productName).build());
        ProductByNameRequestDto body = ProductByNameRequestDto.builder().method(productProperties.getFilter()).params(params).build();
        ProductResponseDto response = postAndGetEntity(body, ProductResponseDto.class);
        return response.getResult().stream().findFirst().orElse(new ProductDto());
    }

    public ProductDto createProduct(CreateProductDto createProduct) {
        CreateProductRequestDto body = CreateProductRequestDto.builder().method(productProperties.getCreate()).params(List.of(createProduct)).build();
        CreateProductResponseDto ProductResponseDto = postAndGetEntity(body, CreateProductResponseDto.class);
        return ProductResponseDto.getResult();
    }

}
