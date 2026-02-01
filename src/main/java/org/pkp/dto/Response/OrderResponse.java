package org.pkp.dto.Response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class OrderResponse {
    private int orderID;
    private String customerID;
    private int employeeID;
    private LocalDate orderDate;
    private LocalDate  requiredDate;
    private LocalDate  shippedDate;
    private int shipVia;
    private BigDecimal freight;
    private String shipName;

    private String shipAddress;

    private String shipCity	;

    private String shipRegion;

    private String shipPostalCode;

    private String shipCountry;
}
