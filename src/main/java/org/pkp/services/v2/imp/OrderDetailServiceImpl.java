package org.pkp.services.v2.imp;

import org.pkp.Exception.ResourceNotFoundException;
import org.pkp.dto.v2.request.OrderDetailRequest;
import org.pkp.dto.v2.response.FullOrderDetailResponse;
import org.pkp.dto.v2.response.OrderDetailSaveResponse;
import org.pkp.entity.Order;
import org.pkp.entity.OrderDetail;
import org.pkp.entity.OrderDetailId;
import org.pkp.entity.Product;
import org.pkp.mapper.v2.OrderDetailMapper;
import org.pkp.repository.OrderDetailRepository;
import org.pkp.repository.OrderRepository;
import org.pkp.repository.ProductRepository;
import org.pkp.services.v2.OrderDetailService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    private final OrderDetailRepository repository;
    private final OrderDetailMapper mapper;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    public OrderDetailServiceImpl(OrderDetailRepository repository, OrderDetailMapper mapper,OrderRepository orderRepository,
                                  ProductRepository productRepository){
        this.repository=repository;
        this.mapper=mapper;
        this.orderRepository=orderRepository;
        this.productRepository=productRepository;
    }

    @Override
    public OrderDetailSaveResponse save(OrderDetailRequest request) {
        OrderDetail detail = mapper.toEntity(request);

        // Fetch Order first
        Order order = orderRepository.findById(request.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));
        // Attach Order to OrderDetail
        detail.setOrder(order);

        Product product=productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        detail.setProduct(product);

        detail.setId(new OrderDetailId(
                order.getOrderID(),
                product.getProductID()
        ));
        OrderDetail saved = repository.save(detail);

        return new OrderDetailSaveResponse(
                "Order detail saved successfully",
                saved.getOrder().getOrderID(),
                saved.getProduct().getProductID()
        );
    }
    @Override
    public List<FullOrderDetailResponse> findByOrderId(Integer orderId) {
        return repository.findByIdOrderId(orderId)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public FullOrderDetailResponse findByOrderIdAndProductId(
            Integer orderId, Integer productId) {

        return repository.findByIdOrderIdAndIdProductId(orderId, productId)
                .map(mapper::toResponse)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "OrderDetail not found for OrderId "
                                        + orderId + " and ProductId " + productId
                        ));
    }
}
