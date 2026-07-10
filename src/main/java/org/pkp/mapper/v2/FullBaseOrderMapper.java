package org.pkp.mapper.v2;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.pkp.dto.v2.request.OrderDetailRequest;
import org.pkp.dto.v2.request.OrderRequest;
import org.pkp.dto.v2.response.FullOrderDetailResponse;
import org.pkp.dto.v2.response.FullOrderResponse;
import org.pkp.entity.Order;
import org.pkp.entity.OrderDetail;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FullBaseOrderMapper {
    @Mapping(target = "orderID", ignore = true)

    @Mapping(target = "customer", ignore = true)
    @Mapping(target = "employee", ignore = true)
    @Mapping(target = "shipVia", ignore = true)

    @Mapping(target = "orderDate", ignore = true)

    @Mapping(source = "details", target = "orderDetails")
    Order toEntity(OrderRequest request);


    @Mapping(target = "order", ignore = true)
    @Mapping(target = "product", ignore = true)
    @Mapping(target = "id", ignore = true)
    OrderDetail toDetailEntity(OrderDetailRequest dto);


    // ---------------------------
    // Entity → Response
    // ---------------------------
    @Mapping(source = "orderID", target = "orderId")
    @Mapping(source = "customer.customerID", target = "customerId")
    @Mapping(source = "employee.employeeID", target = "employeeId")

    // FIX: shipVia Object → shipperID
    @Mapping(source = "shipVia.shipperID", target = "shipVia")

    @Mapping(source = "orderDetails", target = "details")
    FullOrderResponse toResponse(Order order);

    List<FullOrderResponse> toOrderResponseList(List<Order> orders);


    @Mapping(source = "product.productID", target = "productId")
    FullOrderDetailResponse toDetailResponse(OrderDetail detail);


    // ---------------------------
    // After Mapping
    // ---------------------------
    @AfterMapping
    default void linkDetails(@MappingTarget Order order) {
        if (order.getOrderDetails() != null) {
            for (OrderDetail detail : order.getOrderDetails()) {
                detail.setOrder(order);
            }
        }
    }
}
