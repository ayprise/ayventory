package com.ayprise.inventory.controller;


import com.ayprise.inventory.model.Product;
import com.ayprise.inventory.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Product")
@RequestMapping("/inventory/product/")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product get(@PathVariable("id") long id) {
        return productService.getProduct(id);
    }

    @PostMapping
    public void create(@RequestBody Product product) {
        productService.addNewProduct(product);
    }

}
