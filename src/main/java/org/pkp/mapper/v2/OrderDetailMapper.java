package org.pkp.mapper.v2;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.pkp.dto.v2.request.OrderDetailRequest;
import org.pkp.dto.v2.response.FullOrderDetailResponse;
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
