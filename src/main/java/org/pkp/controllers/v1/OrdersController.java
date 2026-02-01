package org.pkp.controllers.v1;

import lombok.RequiredArgsConstructor;
import org.pkp.dto.Response.AllOrderResponse;
import org.pkp.dto.Response.OrderDetailResponse;
import org.pkp.dto.Response.OrderResponse;
import org.pkp.entity.Order;
import org.pkp.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrdersController {
    @Autowired
    private final OrdersService service;

    @GetMapping("/full")
    public ResponseEntity<List<AllOrderResponse>> findAllOrder() {
        try{
            var output=service.findAllOrder();
            return ResponseEntity.ok(output);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @GetMapping
    public ResponseEntity<List<OrderResponse>> findAll() {
        try{
            var output=service.findAll();
            return ResponseEntity.ok(output);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> findById(@PathVariable int id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Map<String, String> save(@RequestBody Order dto) {
        Order success= service.save( dto);
        if ( (success != null && success.getCustomer()!= null)) {
            return Map.of("message", "Customers created successfully");
        }
        else {
            return Map.of("message", "Faill to Create Orders.");
        }
    }

    @DeleteMapping("/{id}")
    public Map<String, String>  Delete(@PathVariable int id) {

        try{
            service.deleteById(id);
            return Map.of("message", "Orders deleted successfully");
        } catch (Exception e) {
            return Map.of("message", "Faill to deleted Orders.");
        }
    }

    @GetMapping("/by-name-city")
    public List<Order> findByShipNameAndShipCity(
            @RequestParam String ShipName,
            @RequestParam String ShipCity) {

        return service.findByShipNameAndShipCity(ShipName, ShipCity);
    }

    @GetMapping("/postal")
    public ResponseEntity<List<Order>> findByShipPostalCodeContaining(
            @RequestParam(required = false, defaultValue = "") String shipPostalCode) {

        return ResponseEntity.ok(service.findByShipPostalCodeContaining(shipPostalCode));
    }

    @GetMapping("/cname")
    public ResponseEntity<List<Order>> findByShipName(
            @RequestParam(required = false, defaultValue = "") String ShipName) {

        return ResponseEntity.ok(service.findByShipName(ShipName));
    }
//    @GetMapping("/custId")
//    public ResponseEntity<List<OrderEntity>> findByCustomerID(
//            @RequestParam(required = false, defaultValue = "") String customerID) {
//        return ResponseEntity.ok(service.findByCustomerID(customerID));
//    }

}
