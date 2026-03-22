package org.pkp.dto.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryResponse {
    private int categoryID;

    private String categoryName;

    private String description;
}
