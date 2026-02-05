package org.pkp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.pkp.dto.Request.OrderDetailRequest;
import org.pkp.dto.Response.OrderDetailResponse;
import org.pkp.entity.OrderDetail;

@Mapper(componentModel = "spring")
public interface OrderDetailMapper {
    //@Mapping(source = "productId", target = "productResponse")
    // Request DTO → Entity
    OrderDetail toEntity(OrderDetailRequest request);

    // Entity → Response DTO
    @Mapping(target = "quantity", source = "quantity")
    OrderDetailResponse toResponse(OrderDetail entity);
}
