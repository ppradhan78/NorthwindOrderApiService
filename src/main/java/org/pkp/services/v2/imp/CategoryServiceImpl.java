package org.pkp.services.v2.imp;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.pkp.dto.v2.request.CategoryRequest;
import org.pkp.dto.v2.response.CategoryResponse;
import org.pkp.entity.Category;
import org.pkp.mapper.v2.CategoryMapper;
import org.pkp.repository.CategoryRepository;
import org.pkp.services.v2.CategoryService;
import org.pkp.utlity.NullPropertyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired private CategoryRepository repository;
    @Autowired
    private CategoryMapper mapper;

    public List<CategoryResponse> getAll() {
        return repository.findAll().stream()
                .map(mapper::toResponse).collect(Collectors.toList());
    }

    public CategoryResponse save(CategoryRequest dto) {
        Category entity = mapper.toEntity(dto);
        return mapper.toResponse(repository.save(entity));
    }

    // DQL: Get by ID
    public CategoryResponse getById(int id) {
        Category category = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + id));
        return mapper.toResponse(category);
    }

    // DML: Update
    @Transactional
    public CategoryResponse update(int id, CategoryRequest dto) {
        try {
            // 1. Fetch (DQL)
            Category existingCategory = repository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Category " + id + " not found"));

            // 2. Manual Update (or use Mapper)
            existingCategory.setCategoryName(dto.getCategoryName());
            existingCategory.setDescription(dto.getDescription());

            // 3. Save & Flush
            // We use saveAndFlush() to force the DB check IMMEDIATELY so we can catch the error here
            Category savedCategory = repository.saveAndFlush(existingCategory);

            return mapper.toResponse(savedCategory);

        } catch (DataIntegrityViolationException e) {
            // This catches SQL constraint issues (like a Description being too long)
            throw new RuntimeException("Database constraint violation: " + e.getMostSpecificCause().getMessage());
        } catch (Exception e) {
            // Catch-all for other commit failures
            throw new RuntimeException("Failed to update category: " + e.getMessage());
        }
    }

    // DML: Delete
    public void delete(int id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Cannot delete; ID " + id + " does not exist.");
        }
        repository.deleteById(id);
    }

    public CategoryResponse patchCategory(int id, CategoryRequest dto) {

        Category existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        // Copy only non-null fields
        BeanUtils.copyProperties(dto, existing,
                NullPropertyUtil.getNullPropertyNames(dto));
        repository.save(existing);
        return mapper.toResponse(existing);

    }
}
