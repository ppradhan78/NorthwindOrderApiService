package org.pkp.mapper.v1;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.pkp.dto.v1.request.ProductRequest;
import org.pkp.dto.v1.response.ProductResponse;
import org.pkp.entity.Product;

import java.util.List;

@Mapper(componentModel = "spring", implementationName = "ProductMapperV1Impl")
public interface ProductMapper {
    ProductResponse toResponse(Product product);
    List<ProductResponse> toResponseList(List<Product> products);
    Product toEntity(ProductRequest productDto);
    @Mapping(target = "productID", ignore = true) // Don't let the DTO change the ID
    void updateEntityFromDto(ProductRequest dto, @MappingTarget Product entity);
}

