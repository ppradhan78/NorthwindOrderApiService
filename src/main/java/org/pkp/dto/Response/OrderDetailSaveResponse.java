package org.pkp.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDetailSaveResponse {
    private String message;
    private int orderId;
    private int productId;
}