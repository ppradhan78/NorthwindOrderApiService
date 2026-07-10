package org.pkp.controllers.v1;

import lombok.RequiredArgsConstructor;
import org.pkp.dto.v2.request.OrderRequest;
import org.pkp.dto.v2.response.FullBaseOrderResponse;
import org.pkp.dto.v2.response.OrderResponse;
import org.pkp.dto.v2.response.OrderSaveResponse;
import org.pkp.services.v2.OrdersService;
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
    public ResponseEntity<List<FullBaseOrderResponse>> findAllOrder() {
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
    public ResponseEntity<OrderResponse> findById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OrderSaveResponse> save(@RequestBody OrderRequest dto) {
        OrderSaveResponse response= service.save(dto);
        return ResponseEntity.ok(response);

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
    @GetMapping("/by-ship-name-city")
    public List<OrderResponse> findByShipNameAndShipCity(
            @RequestParam String ShipName,
            @RequestParam String ShipCity) {

        return service.findByShipNameAndShipCity(ShipName, ShipCity);
    }

    @GetMapping("/ship-postalCode")
    public ResponseEntity<List<OrderResponse>> findByShipPostalCodeContaining(
            @RequestParam(required = false, defaultValue = "") String shipPostalCode) {

        return ResponseEntity.ok(service.findByShipPostalCodeContaining(shipPostalCode));
    }

    @GetMapping("/ShipName")
    public ResponseEntity<List<OrderResponse>> findByShipName(
            @RequestParam(required = false, defaultValue = "") String ShipName) {

        return ResponseEntity.ok(service.findByShipName(ShipName));
    }
    @GetMapping("/customerId")
    public ResponseEntity<List<OrderResponse>> findByCustomerID(
            @RequestParam(required = false, defaultValue = "") String customerID) {
        return ResponseEntity.ok(service.findByCustomerID(customerID));
    }

}
