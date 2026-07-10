package org.pkp.mapper.v2;

import org.mapstruct.Mapper;
import org.pkp.dto.v2.response.ProductResponse;
import org.pkp.entity.Product;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductResponse toResponse(Product product);
    List<ProductResponse> toResponseList(List<Product> product);
}