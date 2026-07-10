package org.pkp.controllers.v1;

import jakarta.validation.Valid;
import org.pkp.dto.v2.request.OrderDetailRequest;
import org.pkp.dto.v2.response.FullOrderDetailResponse;
import org.pkp.dto.v2.response.OrderDetailSaveResponse;
import org.pkp.services.v2.OrderDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<FullOrderDetailResponse>> getByOrderId(
            @PathVariable Integer orderId) {
        return ResponseEntity.ok(service.findByOrderId(orderId));
    }

    // 2. Get detail by orderId + productId
    @GetMapping("/order/{orderId}/product/{productId}")
    public ResponseEntity<FullOrderDetailResponse> getByOrderIdAndProductId(
            @PathVariable Integer orderId,
            @PathVariable Integer productId) {
        return ResponseEntity.ok(
                service.findByOrderIdAndProductId(orderId, productId)
        );
    }
}
