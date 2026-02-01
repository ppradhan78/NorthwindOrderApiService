package org.pkp.mapper;

import org.mapstruct.Mapper;
import org.pkp.dto.Response.AllOrderResponse;
import org.pkp.dto.Response.CustomerResponse;
import org.pkp.dto.Response.EmployeeResponse;
import org.pkp.dto.Response.OrderResponse;
import org.pkp.entity.Customer;
import org.pkp.entity.Order;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    // ✅ Entity → DTO
    OrderResponse toResponse(Order entity);
    // ✅ List<Entity> → List<DTO>
    List<OrderResponse> toResponseList(List<Order> entity);
}

//public class OrderMapper {
//
//    public static AllOrderResponse toAllResponse(Order entity){
//        AllOrderResponse or=new AllOrderResponse();
//
//        OrderResponse r = new OrderResponse();
//        r.setOrderID(entity.getOrderID());
//        if (entity.getCustomer() != null) {
//            r.setCustomerID(entity.getCustomer().getCustomerID());
//        }
//        if (entity.getEmployee() != null) {
//            r.setEmployeeID(entity.getEmployee().getEmployeeID());
//        }
//
//        CustomerResponse cr =new CustomerResponse();
//        or.setCustomerResponse(cr);
//        EmployeeResponse er =new EmployeeResponse();
//        or.setEmployeeResponse(er);
//
//        r.setOrderDate(entity.getOrderDate());
//        r.setRequiredDate(entity.getRequiredDate());
//        r.setShippedDate(entity.getShippedDate());
//        r.setFreight(entity.getFreight());
//        r.setShipName(entity.getShipName());
//        r.setShipAddress(entity.getShipAddress());
//        r.setShipCity(entity.getShipCity());
//        r.setShipRegion(entity.getShipRegion());
//        r.setShipPostalCode(entity.getShipPostalCode());
//        r.setShipCountry(entity.getShipCountry());
//
//        or.setOrderBaseResponse(r);
//
//        return or;
//    }
//
//    public static OrderResponse toResponse(Order entity) {
//        OrderResponse r = new OrderResponse();
//        r.setOrderID(entity.getOrderID());
//        if (entity.getCustomer() != null) {
//            r.setCustomerID(entity.getCustomer().getCustomerID());
//        }
//        if (entity.getEmployee() != null) {
//            r.setEmployeeID(entity.getEmployee().getEmployeeID());
//        }
//        r.setOrderDate(entity.getOrderDate());
//        r.setRequiredDate(entity.getRequiredDate());
//        r.setShippedDate(entity.getShippedDate());
//        r.setFreight(entity.getFreight());
//        r.setShipName(entity.getShipName());
//        r.setShipAddress(entity.getShipAddress());
//        r.setShipCity(entity.getShipCity());
//        r.setShipRegion(entity.getShipRegion());
//        r.setShipPostalCode(entity.getShipPostalCode());
//        r.setShipCountry(entity.getShipCountry());
//        return r;
//    }
//
//    public static List<OrderResponse> toResponseList(List<Order> entities) {
//        if (entities == null || entities.isEmpty()) {
//            return List.of();
//        }
//        return entities.stream()
//                .map(OrderMapper::toResponse)
//                .collect(Collectors.toList());
//    }
//}
