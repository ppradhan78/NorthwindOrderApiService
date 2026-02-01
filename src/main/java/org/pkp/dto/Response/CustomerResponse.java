package org.pkp.dto.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResponse {
    private String customerID;
    private String companyName;
    private String contactName;
    private String contactTitle	;
    private String address;
    private String city;
    private String region;
    private String postalCode;
    private String country;
    private String phone;
    private String fax;
}
