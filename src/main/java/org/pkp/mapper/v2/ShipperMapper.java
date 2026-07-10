package org.pkp.mapper.v2;

import org.mapstruct.Mapper;
import org.pkp.dto.v2.response.ShipperResponse;
import org.pkp.entity.Shipper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShipperMapper {
    ShipperResponse toResponse(Shipper shipper);
    List<ShipperResponse> toResponseList(List<Shipper> shipper);
}
