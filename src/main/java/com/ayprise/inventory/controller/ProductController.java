package com.ayprise.inventory.controller;


import com.ayprise.inventory.model.CreateProductRequest;
import com.ayprise.inventory.model.CreateProductResponse;
import com.ayprise.inventory.model.GetProductResponse;
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
    public GetProductResponse get(@PathVariable("id") long id) {
        final var product = productService.getProduct(id);
        if (product == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return GetProductResponse.fromProduct(product);
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CreateProductResponse create(@RequestBody CreateProductRequest request) {
        final var optional = productService.addProduct(request.toProduct());
        return CreateProductResponse.builder()
                .withId(optional.orElse(-1L))
                .withStatus(optional.isPresent() ? HttpStatus.CREATED : HttpStatus.CONFLICT)
                .build();
    }

}
