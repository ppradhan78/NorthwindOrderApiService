package org.pkp.mapper;

import org.mapstruct.Mapper;
import org.pkp.dto.OrdersDto;
import org.pkp.entity.Orders;
import org.pkp.model.OrdersModel;

import java.util.List;


@Mapper(componentModel = "spring")
public interface OrdersMapper {
    OrdersDto modeltoDto(OrdersModel model);
    OrdersModel dtotoModel(OrdersDto dto);

    OrdersModel entityToModel(Orders entity);

    Orders modelToEntity(OrdersModel model);

    List<OrdersDto> toDtoList(List<Orders> entities);

}
