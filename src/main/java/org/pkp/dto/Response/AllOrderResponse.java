package org.pkp.dto.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AllOrderResponse {
    private OrderResponse orderBaseResponse;
    private CustomerResponse customerResponse;
    private EmployeeResponse employeeResponse;
}
