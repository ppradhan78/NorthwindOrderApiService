package org.pkp.dto.Response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class OrderResponse {

    private Integer orderId;

    private String customerId;
    private Integer employeeId;

    private Integer shipVia; // ShipperID

    private LocalDate orderDate;
    private BigDecimal freight;

    private List<OrderDetailResponse> details;
}
