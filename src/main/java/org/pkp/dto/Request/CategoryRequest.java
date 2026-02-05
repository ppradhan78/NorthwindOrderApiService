package org.pkp.dto.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.pkp.validation.ValidCategoryName;
@Getter
@Setter
public class CategoryRequest {

    @NotBlank(message = "Category name is required")
    @Size(min = 2, max = 50, message = "Category name must be between 2 and 50 characters")
    @ValidCategoryName
    private String categoryName;

    // getters & setters
}
