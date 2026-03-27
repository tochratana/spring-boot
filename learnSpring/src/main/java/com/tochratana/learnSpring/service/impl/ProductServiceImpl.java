package com.tochratana.learnSpring.service.impl;

import com.tochratana.learnSpring.domain.Category;
import com.tochratana.learnSpring.domain.Product;
import com.tochratana.learnSpring.dto.ProductResponse;
import com.tochratana.learnSpring.dto.RequestProduct;
import com.tochratana.learnSpring.dto.UpdateProductRequest;
import com.tochratana.learnSpring.mapper.ProductMapper;
import com.tochratana.learnSpring.repository.CategoryRepository;
import com.tochratana.learnSpring.repository.ProductRepository;
import com.tochratana.learnSpring.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    private final ProductMapper productMapper;


    @Override
    public ProductResponse createNew(RequestProduct requestProduct) {
        // TODO: write your business logic
        // 1. Validate category ID (exists or not)
        Category category = categoryRepository.findById(requestProduct.categoryID())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));



        // 2. Transfer data from DTO to Entity
        Product product = new Product();
        product.setName(requestProduct.name());

        product.setDescription(requestProduct.description());
        product.setPrice(requestProduct.price());

        product.setQty(requestProduct.qty());
        product.setCategory(category);


        // 3. System data
        product.setIsAvailable(true);
        product.setCode("ISTAD-" + UUID.randomUUID().toString());


        // 4. Save into database
        product = productRepository.save(product);


        // 5. Transfer data from Entity to DTO
        return ProductResponse.builder()
                .code(product.getCode())
                .name(product.getName())
                .price(product.getPrice())
                .qty(product.getQty())
                .description(product.getDescription())
                .isAvailable(product.getIsAvailable())
                .category(product.getCategory().getName())
                .build();
    }

    @Override
    public Page<ProductResponse> getAllProduct(int pageNumber, int pageSize) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        return productRepository.findAll(pageable)
                .map(productMapper::toProductResponse);
    }

    @Override
    public String deleteProductByCode(String code) {
        // 1. Validation if code don't have
        Product product = productRepository.findById(code).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Code Not Found"));
        productRepository.delete(product);
        return code;
    }

    @Override
    public ProductResponse getProductByCode(String code) {
        // 1. validation if code don't have
        Product product = productRepository.findById(code).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Code Not Found"));
        return productMapper.toProductResponse(product);
    }

    @Override
    public ProductResponse updateProductByCode(String code, UpdateProductRequest updateProductRequest) {
        // TODO: validate product code
        Product product = productRepository.findById(code).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Code Not Found"));

        //product.setCode(updateProductRequest.name());

        productMapper.toUpdateProductRequest(updateProductRequest, product);
        product = productRepository.save(product);

        return productMapper.toProductResponse(product);
    }
}
