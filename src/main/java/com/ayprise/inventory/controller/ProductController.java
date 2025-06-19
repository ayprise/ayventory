package com.ayprise.inventory.controller;


import com.ayprise.inventory.model.Product;
import com.ayprise.inventory.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Product")
@RequestMapping("/inventory/product/")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product get(@PathVariable("id") String id) {
        return productService.getProduct(Long.parseLong(id)).toProduct();
    }

    @PostMapping
    public void create(@RequestBody Product product) {
        productService.addNewProduct(product);
    }

}
