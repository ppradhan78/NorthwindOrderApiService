package org.pkp.dto.v2.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FullBaseOrderResponse {
    private FullOrderResponse orderBaseResponse;
    private CustomerResponse customerResponse;
    private EmployeeResponse employeeResponse;
    private ShipperResponse shipperResponse;
    //private ProductResponse productResponse;
}
