package org.pkp.controllers.v1;

import lombok.RequiredArgsConstructor;
import org.pkp.entity.Orders;
import org.pkp.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrdersController {
    @Autowired
    private final OrdersService service;

    @GetMapping
    public ResponseEntity<List<Orders>> findAll() {
        try{
            return ResponseEntity.ok(service.findAll());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Orders>> findById(@PathVariable int id) {
        Optional<Orders> customers= service.findById(id);
        if (customers.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok(customers);
        }

    }

    @PostMapping
    public Map<String, String> save(@RequestBody Orders dto) {
        Orders success= service.save( dto);
        if ( (success != null && success.getCustomerID() != null)|| !success.getCustomerID().isEmpty()) {
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
    public List<Orders> findByShipNameAndShipCity(
            @RequestParam String ShipName,
            @RequestParam String ShipCity) {

        return service.findByShipNameAndShipCity(ShipName, ShipCity);
    }

    @GetMapping("/postal")
    public ResponseEntity<List<Orders>> findByShipPostalCodeContaining(
            @RequestParam(required = false, defaultValue = "") String shipPostalCode) {

        return ResponseEntity.ok(service.findByShipPostalCodeContaining(shipPostalCode));
    }

    @GetMapping("/cname")
    public ResponseEntity<List<Orders>> findByShipName(
            @RequestParam(required = false, defaultValue = "") String ShipName) {

        return ResponseEntity.ok(service.findByShipName(ShipName));
    }
}
