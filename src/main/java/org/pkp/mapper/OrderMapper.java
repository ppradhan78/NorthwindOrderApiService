package org.pkp.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.pkp.dto.Request.OrderDetailRequest;
import org.pkp.dto.Request.OrderRequest;
import org.pkp.dto.Response.OrderDetailResponse;
import org.pkp.dto.Response.OrderResponse;
import org.pkp.entity.Order;
import org.pkp.entity.OrderDetail;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
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
    OrderResponse toResponse(Order order);

    List<OrderResponse> toOrderResponseList(List<Order> orders);


    @Mapping(source = "product.productID", target = "productId")
    OrderDetailResponse toDetailResponse(OrderDetail detail);


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
