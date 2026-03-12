package com.tochratana.learnSpring.controller;

import com.tochratana.learnSpring.dto.ProductResponse;
import com.tochratana.learnSpring.dto.RequestProduct;
import com.tochratana.learnSpring.dto.UpdateProduct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@Slf4j
public class ProductController {


    @GetMapping
    public List<ProductResponse> getAllProducts(){
        log.info("Get All Product : ");
        return List.of();
    }

    @GetMapping("/{code}")
    public ProductResponse getProductByCode(
            @PathVariable String code
    ){
        log.info("Get this product code : {}", code);
        return null;
    }

    @PostMapping
    public ProductResponse createNewProduct(
            @RequestBody RequestProduct requestProduct
    ){
        log.info("Product that have create : {}", requestProduct);
        return null;
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
    public void deleteProductByCode(@PathVariable String code){
        log.info("Delete Product : {}", code );
    }
}
