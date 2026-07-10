package org.pkp.mapper.v2;

import org.mapstruct.Mapper;
import org.pkp.dto.v2.response.EmployeeResponse;
import org.pkp.entity.Employee;

import java.util.List;


@Mapper(componentModel = "spring")
public interface EmployeesMapper {
    EmployeeResponse toResponse(Employee employee);
    List<EmployeeResponse> toResponseList(List<Employee> employee);
}