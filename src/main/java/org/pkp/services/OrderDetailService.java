package org.pkp.services;

import org.pkp.dto.Request.OrderDetailRequest;
import org.pkp.dto.Response.FullOrderDetailResponse;
import org.pkp.dto.Response.OrderDetailSaveResponse;
import org.pkp.entity.OrderDetail;

import java.util.List;
import java.util.Optional;

public interface OrderDetailService {
    OrderDetailSaveResponse save(OrderDetailRequest request);
    List<FullOrderDetailResponse> findByOrderId(Integer orderId);
    FullOrderDetailResponse findByOrderIdAndProductId(
            Integer orderId, Integer productId);
}
