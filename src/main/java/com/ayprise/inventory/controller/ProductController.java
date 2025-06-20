package com.ayprise.inventory.controller;


import com.ayprise.inventory.model.Product;
import com.ayprise.inventory.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@Tag(name = "Product")
@RequestMapping("/inventory/product/")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product get(@PathVariable("id") long id) {
        final var product = productService.getProduct(id);
        if (product == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return product;
    }

    @PostMapping
    public void create(@RequestBody Product product) {
        productService.addProduct(product);
    }

}
