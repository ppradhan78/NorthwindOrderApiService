package org.pkp.controllers.v1;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.pkp.dto.Request.OrderRequest;
import org.pkp.dto.Response.FullBaseOrderResponse;
import org.pkp.dto.Response.OrderResponse;
import org.pkp.dto.Response.OrderSaveResponse;
import org.pkp.services.LambdaStreamApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/LambdaStream")
@RequiredArgsConstructor
public class LambdaStreamApiController {
    @Autowired
    private final LambdaStreamApiService service;

    @GetMapping("/employeeID/employee")
    @Operation(
            summary = "Filter Order by employeeID",
            description = "Returns order based on the employeeID.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Order found successfully"),
                    @ApiResponse(responseCode = "404", description = "Order not found"),
                    @ApiResponse(responseCode = "500", description = "Server error")
            }
    )
    public ResponseEntity<List<OrderResponse>> findAllOrder(Integer employeeID) {
        try{
            var output=service.findAllOrder(employeeID);
            return ResponseEntity.ok(output);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Operation(summary = "Filter Order by employeeID, ShipVia and ShipCity",
            description = "Returns order based on the employeeID, ShipVia and ShipCity." )
    @GetMapping("/filter")
    public ResponseEntity<List<OrderResponse>> findAllOrder(
            @RequestParam(required = true) Integer employeeID,
            @RequestParam(required = true) Integer shipVia,
            @RequestParam(required = true) String shipCity
    ){
        try{
            var output=service.findAllOrder(employeeID,shipVia,shipCity);
            return ResponseEntity.ok(output);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Operation(
            summary = "Get orders for an employee sorted by country",
            description = "Retrieves all orders for a specific employee ID and sorts the results by ShipCountry in Ascending order."
    )
    @GetMapping("/employee/{employeeID}/SortedAsc")
    public ResponseEntity<List<OrderResponse>> findAllOrderSortByShipCountryAsc(
            @Parameter(description = "The ID of the employee to filter by", example = "5")
            @PathVariable Integer employeeID
    ) {
        var output = service.findAllOrderSortByShipCountryAsc(employeeID);
        return ResponseEntity.ok(output);
    }

    @Operation(
            summary = "Get orders for an employee sorted by country",
            description = "Retrieves all orders for a specific employee ID and sorts the results by ShipCountry in Desending order."
    )
    @GetMapping("/employee/{employeeID}/SortedDesc")
    public ResponseEntity<List<OrderResponse>> findAllOrderSortByShipCountryDesc(
            @Parameter(description = "The ID of the employee to filter by", example = "5")
            @PathVariable Integer employeeID
    ) {
        var output = service.findAllOrderSortByShipCountryDesc(employeeID);
        return ResponseEntity.ok(output);
    }


    @GetMapping("/limit/limit")
    @Operation(summary = "limit Order",description = "Returns order based on the limit.")
    public ResponseEntity<List<OrderResponse>> findAllOrderLimit(Integer limit) {
        try{
            var output=service.findAllOrderLimit(limit);
            return ResponseEntity.ok(output);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/skip/skip")
    @Operation(summary = "skip Order ", description = "Returns order based on the skip." )
    public ResponseEntity<List<OrderResponse>> findAllOrderSkip(Integer skip) {
        try{
            var output=service.findAllOrderSkip(skip);
            return ResponseEntity.ok(output);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
