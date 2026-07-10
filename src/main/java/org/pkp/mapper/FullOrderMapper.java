package org.pkp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.pkp.dto.Response.FullBaseOrderResponse;
import org.pkp.entity.Order;

import java.util.List;

@Mapper(componentModel = "spring",uses = {FullBaseOrderMapper.class, CustomerMapper.class, EmployeesMapper.class})
public interface FullOrderMapper {

    // ✅ Map Order → AllOrderResponse
    @Mapping(source = "order", target = "orderBaseResponse")
    @Mapping(source = "customer", target = "customerResponse")
    @Mapping(source = "employee", target = "employeeResponse")
    @Mapping(source = "shipVia", target = "shipperResponse")
    //@Mapping(source = "product", target = "productResponse")
    FullBaseOrderResponse toAllOrderResponse(Order order);

    // ✅ List Mapping
    List<FullBaseOrderResponse> toAllOrderResponseList(List<Order> orders);
}