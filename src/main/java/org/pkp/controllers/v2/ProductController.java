package org.pkp.controllers.v2;

import org.pkp.dto.v2.response.ProductResponse;
import org.pkp.services.v2.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("productControllerV2") // <-- Explicit bean name
@RequestMapping("/api/v2/product")
public class ProductController {

    @Autowired
    private ProductService service;

    // DQL - GET
    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}