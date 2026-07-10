package org.pkp.dto.v2.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderSaveResponse {
    private String message;
    private Integer orderId;
}