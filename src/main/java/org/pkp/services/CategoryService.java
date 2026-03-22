package org.pkp.services;

import org.pkp.dto.Request.CategoryRequest;
import org.pkp.dto.Response.CategoryResponse;

import java.util.List;
import java.util.Map;

public interface CategoryService {

    List<CategoryResponse> getAll();
    CategoryResponse save(CategoryRequest dto);
    CategoryResponse getById(int id);
    CategoryResponse update(int id, CategoryRequest dto);
    void delete(int id);
    CategoryResponse patchCategory(int id, CategoryRequest dto);
}
