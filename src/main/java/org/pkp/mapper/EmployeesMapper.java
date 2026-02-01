package org.pkp.mapper;

import org.mapstruct.Mapper;
import org.pkp.dto.Response.EmployeeResponse;
import org.pkp.entity.Employee;

import java.util.List;


@Mapper(componentModel = "spring")
public interface EmployeesMapper {
    EmployeeResponse toResponse(Employee employee);
    List<EmployeeResponse> toResponseList(List<Employee> employee);
}