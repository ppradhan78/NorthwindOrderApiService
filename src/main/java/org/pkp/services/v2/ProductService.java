package org.pkp.services.v2;

import org.pkp.dto.v2.response.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAll();
}
