package org.pkp.dto.Request;

import lombok.Data;

@Data
public class OrderDetailRequest {

    private int orderId;
    private int productId;
    private double unitPrice;
    private int quantity;
    private float discount;
}

