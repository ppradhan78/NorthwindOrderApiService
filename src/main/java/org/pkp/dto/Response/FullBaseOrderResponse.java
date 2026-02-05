package org.pkp.dto.Response;

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
