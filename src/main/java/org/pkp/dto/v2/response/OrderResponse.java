package org.pkp.dto.v2.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class OrderResponse {
    private Integer orderId;

    private String customerId;
    private Integer employeeId;

    private Integer shipVia; // ShipperID

    private LocalDate orderDate;
    private BigDecimal freight;
    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String shipRegion;
    private String shipPostalCode;
    private String shipCountry;
}