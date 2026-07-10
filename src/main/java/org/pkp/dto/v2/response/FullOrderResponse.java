package org.pkp.dto.v2.response;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class FullOrderResponse {

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

    @NotEmpty
    private List<FullOrderDetailResponse> details;
}
