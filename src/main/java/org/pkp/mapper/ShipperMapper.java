package org.pkp.mapper;

import org.mapstruct.Mapper;
import org.pkp.dto.Response.ShipperResponse;
import org.pkp.entity.Shipper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShipperMapper {
    ShipperResponse toResponse(Shipper shipper);
    List<ShipperResponse> toResponseList(List<Shipper> shipper);
}
