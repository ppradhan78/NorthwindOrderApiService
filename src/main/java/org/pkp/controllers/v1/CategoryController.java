package org.pkp.controllers.v1;

import jakarta.validation.Valid;
import org.pkp.dto.v2.request.CategoryRequest;
import org.pkp.dto.v2.response.CategoryResponse;
import org.pkp.services.v2.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @PostMapping("/is-category-exist")
    public ResponseEntity<String> isCategoryExist(
            @Valid @RequestBody CategoryRequest request) {

        return ResponseEntity.ok("Category doesnot exists in a system.");
    }

    @Autowired
    private CategoryService service;

    // DQL - GET
    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // DML - POST (Create)
    @PostMapping
    public ResponseEntity<CategoryResponse> create(@RequestBody CategoryRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }
    // GET /api/categories/5
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id));
    }

    // PUT /api/categories/5
    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> update(@PathVariable int id, @RequestBody CategoryRequest dto) {
        var result=service.update(id, dto);
        return ResponseEntity.ok(result);
    }
    // DML - DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CategoryResponse> patchCategory(
            @PathVariable int id,
            @RequestBody CategoryRequest dto) {

        CategoryResponse updated = service.patchCategory(id, dto);
        return ResponseEntity.ok(updated);
    }
}
