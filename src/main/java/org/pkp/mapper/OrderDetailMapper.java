package org.pkp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.pkp.dto.Request.OrderDetailRequest;
import org.pkp.dto.Response.FullOrderDetailResponse;
import org.pkp.entity.OrderDetail;

@Mapper(componentModel = "spring")
public interface OrderDetailMapper {
    @Mapping(target = "order", ignore = true)
    @Mapping(target = "product", ignore = true)
    @Mapping(target = "id", ignore = true)
    OrderDetail toEntity(OrderDetailRequest request);
    // Entity → Response DTO
    @Mapping(target = "quantity", source = "quantity")
    FullOrderDetailResponse toResponse(OrderDetail entity);
}
