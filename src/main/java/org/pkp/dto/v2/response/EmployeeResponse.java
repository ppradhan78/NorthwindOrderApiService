package org.pkp.dto.v2.response;

import lombok.Getter;
import lombok.Setter;
import org.pkp.entity.Employee;

import java.time.LocalDate;
@Getter
@Setter
public class EmployeeResponse {
    private Integer employeeID;
    private String lastName;
    private String firstName;
    private String title	;
    private String titleOfCourtesy;
    private LocalDate birthDate;
    private LocalDate hireDate;
    private String address;
    private String city;
    private String region;
    private String postalCode;
    private String country;
    private String homePhone;
    private String extension;
    private byte[] photo;
    private String notes;
    private Employee manager;
    private String photoPath;
}
