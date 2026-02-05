package org.pkp.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.pkp.repository.CategoryRepository;
import org.springframework.stereotype.Component;

@Component
public class CategoryNameValidator
        implements ConstraintValidator<ValidCategoryName, String> {

    private final CategoryRepository categoryRepository;

    public CategoryNameValidator(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // Let @NotBlank handle null / empty
        if (value == null || value.isBlank()) {
            return true;
        }
        var result=categoryRepository.existsByCategoryNameIgnoreCase(value.trim());
        return !result;
    }
}