package org.pkp.dto.Request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class OrderRequest {

    @NotNull
    private String customerId;

    @NotNull
    private Integer employeeId;

    @NotNull
    private Integer shipVia;

    private LocalDate requiredDate;
    private LocalDate shippedDate;

    private BigDecimal freight;

    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String shipRegion;
    private String shipPostalCode;
    private String shipCountry;

    @NotEmpty
    private List<OrderDetailRequest> details;
}
