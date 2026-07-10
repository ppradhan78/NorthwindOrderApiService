package org.pkp.services.v2;

import org.pkp.dto.v2.request.CategoryRequest;
import org.pkp.dto.v2.response.CategoryResponse;

import java.util.List;

public interface CategoryService {

    List<CategoryResponse> getAll();
    CategoryResponse save(CategoryRequest dto);
    CategoryResponse getById(int id);
    CategoryResponse update(int id, CategoryRequest dto);
    void delete(int id);
    CategoryResponse patchCategory(int id, CategoryRequest dto);
}
