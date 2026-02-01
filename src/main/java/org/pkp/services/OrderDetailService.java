package org.pkp.services;

import org.pkp.dto.Request.OrderDetailRequest;
import org.pkp.dto.Response.OrderDetailSaveResponse;

public interface OrderDetailService {
    OrderDetailSaveResponse save(OrderDetailRequest request);
}
