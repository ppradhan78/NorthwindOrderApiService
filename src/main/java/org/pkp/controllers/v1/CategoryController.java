package org.pkp.controllers.v1;

import jakarta.validation.Valid;
import org.pkp.dto.Request.CategoryRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @PostMapping("/is-category-exist")
    public ResponseEntity<String> create(
            @Valid @RequestBody CategoryRequest request) {

        return ResponseEntity.ok("Category doesnot exists in a system.");
    }
}
