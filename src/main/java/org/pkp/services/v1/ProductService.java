package org.pkp.services.v1;

import org.pkp.dto.v1.response.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAll();
}
