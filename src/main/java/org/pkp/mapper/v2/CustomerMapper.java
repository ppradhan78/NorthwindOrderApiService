package org.pkp.mapper.v2;

import org.mapstruct.Mapper;
import org.pkp.dto.v2.response.CustomerResponse;
import org.pkp.entity.Customer;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponse toResponse(Customer customer);
    List<CustomerResponse> toResponseList(List<Customer> customers);
}
