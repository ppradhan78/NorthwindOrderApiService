package org.pkp.services.v2;

import org.pkp.dto.v2.request.OrderDetailRequest;
import org.pkp.dto.v2.response.FullOrderDetailResponse;
import org.pkp.dto.v2.response.OrderDetailSaveResponse;

import java.util.List;

public interface OrderDetailService {
    OrderDetailSaveResponse save(OrderDetailRequest request);
    List<FullOrderDetailResponse> findByOrderId(Integer orderId);
    FullOrderDetailResponse findByOrderIdAndProductId(
            Integer orderId, Integer productId);
}
