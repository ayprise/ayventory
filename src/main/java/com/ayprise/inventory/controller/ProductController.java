package com.ayprise.inventory.controller;


import com.ayprise.inventory.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
public class ProductController {
    private final Map<String, Product> products = Map.of("1", new Product("Airpods Pro 2",
            "Electronics",
            "Apple Headphones"));

    @GetMapping(name = "/inventory/product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product get(@PathVariable("id") String id) {
        var product = products.get(id);
        if (product == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return product;
    }

}
