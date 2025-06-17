package com.ayprise.inventory.model;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductController {

    private Map<String, Product> products = new HashMap<>() {{
        put("1", new Product("Airpods Pro 2",
                "Electronics",
                "Apple Headphones"));
    }};

    @GetMapping("/inventory/product/{id}")
    public Product get(@PathVariable("id") String id) {
        Product product = products.get(id);
        if (product == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return product;
    }

}
