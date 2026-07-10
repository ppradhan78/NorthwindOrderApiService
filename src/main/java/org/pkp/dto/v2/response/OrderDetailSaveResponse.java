package org.pkp.dto.v2.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDetailSaveResponse {
    private String message;
    private int orderId;
    private int productId;
}