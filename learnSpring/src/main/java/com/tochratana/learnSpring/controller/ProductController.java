package com.tochratana.learnSpring.controller;

import com.tochratana.learnSpring.dto.ProductResponse;
import com.tochratana.learnSpring.dto.RequestProduct;
import com.tochratana.learnSpring.dto.UpdateProduct;
import com.tochratana.learnSpring.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@Slf4j
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    /**
     *
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @GetMapping
    public Page<ProductResponse> getAllProducts(
            @RequestParam(required = false, defaultValue = "0") int pageNumber,
            @RequestParam(required = false, defaultValue = "25") int pageSize
    ){

        return productService.getAllProduct(pageNumber, pageSize);
    }

    @GetMapping("/{code}")
    public ProductResponse getProductByCode(
            @PathVariable String code
    ){

        log.info("Get this product code : {}", code);
        return  productService.getProductByCode(code);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createNewProduct(
            @Valid @RequestBody RequestProduct requestProduct
    ){
        log.info("Product that have create : {}", requestProduct);
        return productService.createNew(requestProduct);
    }

    @PutMapping("/{code}")
    public ProductResponse updateProduct(
            @PathVariable String code,
            @RequestBody UpdateProduct updateProduct
    ){
        log.info("Update product : {}", updateProduct);
        return null;
    }

    @PatchMapping("/{code}")
    public ProductResponse patchProduct(
            @PathVariable String code,
            @RequestBody UpdateProduct updateProduct
    ){
        log.info("Patch Product : {}", updateProduct);
        return null;
    }

    @DeleteMapping("{code}")
    public String deleteProductByCode(@PathVariable String code){
        return productService.deleteProductByCode(code);
    }
}
