package com.tochratana.learnSpring.service;

import com.tochratana.learnSpring.dto.ProductResponse;
import com.tochratana.learnSpring.dto.RequestProduct;
import org.springframework.data.domain.Page;


public interface ProductService {
    ProductResponse createNew(RequestProduct requestProduct);
    Page<ProductResponse> getAllProduct(int pageNumber, int pageSize);
    String deleteProductByCode(String code);
}
