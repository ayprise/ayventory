package com.ayprise.inventory.controller;


import com.ayprise.inventory.model.Product;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@Tag(name = "Product")
@RequestMapping("/inventory/product/")
public class ProductController {
    private final Map<String, Product> products = Map.of("1", new Product("Airpods Pro 2",
                    "Electronics",
                    "Apple Headphones"),
            "2", new Product("Switch 2 Mario Kart Bundle",
                    "Electronics",
                    "Nintendo Switch 2 Mario Kart Bundle"));

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product get(@PathVariable("id") String id) {
        var product = products.get(id);
        if (product == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return product;
    }

}
