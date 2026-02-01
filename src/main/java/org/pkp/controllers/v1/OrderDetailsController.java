package org.pkp.controllers.v1;

import jakarta.validation.Valid;
import org.pkp.dto.Request.OrderDetailRequest;
import org.pkp.dto.Response.OrderDetailSaveResponse;
import org.pkp.services.OrderDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order-details")
public class OrderDetailsController {

    private final OrderDetailService service;

    public OrderDetailsController(OrderDetailService service){
        this.service=service;
    }

    @PostMapping
    public ResponseEntity<OrderDetailSaveResponse> save(@Valid @RequestBody OrderDetailRequest request )
    {
        OrderDetailSaveResponse response = service.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
