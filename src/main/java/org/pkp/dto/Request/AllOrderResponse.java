package org.pkp.dto.Request;

import lombok.Getter;
import lombok.Setter;
import org.pkp.dto.Response.CustomerResponse;
import org.pkp.dto.Response.EmployeeResponse;
import org.pkp.dto.Response.OrderResponse;

@Getter
@Setter
public class AllOrderResponse {
    private OrderResponse orderBaseResponse;
    private CustomerResponse customerResponse;
    private EmployeeResponse employeeResponse;
}