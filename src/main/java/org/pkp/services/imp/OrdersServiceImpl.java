package org.pkp.services.imp;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.pkp.dto.Request.OrderDetailRequest;
import org.pkp.dto.Request.OrderRequest;
import org.pkp.dto.Response.AllOrderResponse;
import org.pkp.dto.Response.OrderDetailSaveResponse;
import org.pkp.dto.Response.OrderResponse;
import org.pkp.dto.Response.OrderSaveResponse;
import org.pkp.entity.*;
import org.pkp.mapper.AllOrderMapper;
import org.pkp.mapper.OrderMapper;
import org.pkp.repository.*;
import org.pkp.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrdersService {

    private OrderRepository repository;
    private EmployeeRepository employeeRepository;
    private CustomerRepository customerRepository;
    private ProductRepository productRepository;
    private ShipperRepository shipperRepository;
    private final OrderMapper orderMapper;
    private final AllOrderMapper allOrderMapper;

    public OrdersServiceImpl(OrderRepository repository,EmployeeRepository employeeRepository,CustomerRepository customerRepository,
                             ProductRepository productRepository,ShipperRepository shipperRepository, OrderMapper orderMapper,AllOrderMapper allOrderMapper) {
        this.repository = repository;
        this.customerRepository=customerRepository;
        this.employeeRepository=employeeRepository;
        this.productRepository=productRepository;
        this.shipperRepository=shipperRepository;
        this.orderMapper = orderMapper;
        this.allOrderMapper = allOrderMapper;
    }
    @Override
    public List<AllOrderResponse> findAllOrder() {
        return allOrderMapper.toAllOrderResponseList(
                repository.findAllOrder()
        );
    }


    @Override
    public List<OrderResponse> findAll() {
return  null;
        //orderMapper.toResponse(repository.findAll());
      }

    /**
     * @param id
     * @return
     */
//    @Override
//    public Optional<OrderResponse> findById(Integer id) {
//        return null;
////                repository.findById(id)
////                .map(mapper::toResponse);
//    }

//    /**
//     * @param request
//     * @return
//     */
//    @Override
//    public OrderSaveResponse save(OrderRequest request) {
//        // ✅ 1. Validate Customer
//        Customer customer = customerRepository.findById(request.getCustomerID())
//                .orElseThrow(() -> new RuntimeException("Customer not found"));
//
//        // ✅ 2. Validate Employee
//        Employee employee = employeeRepository.findById(request.getEmployeeID())
//                .orElseThrow(() -> new RuntimeException("Employee not found"));
//
//        // ✅ 3. Validate Shipper
//        Shipper shipper = shipperRepository.findById(request.getShipVia())
//                .orElseThrow(() -> new RuntimeException("Shipper not found"));
//
//        // ✅ 4. Create Order entity
//        Order order = new Order();
//        order.setCustomer(customer);     // ✅ Correct
//        order.setEmployee(employee);     // ✅ Correct
//        order.setOrderDate(LocalDate.now());
//        order.setRequiredDate(request.getRequiredDate());
//        order.setShippedDate(request.getShippedDate());
//        order.setShipVia(shipper);     // ✅ Correct
//        order.setFreight(request.getFreight());     // ✅ Correct
//        order.setShipName(request.getShipName());     // ✅ Correct
//        order.setShipAddress(request.getShipAddress());     // ✅ Correct
//        order.setShipCity(request.getShipCity());     // ✅ Correct
//        order.setShipRegion(request.getShipRegion());     // ✅ Correct
//        order.setShipPostalCode(request.getShipPostalCode());     // ✅ Correct
//        order.setShipCountry(request.getShipCountry());     // ✅ Correct
//
//        // ✅ 5. Validate Products + Add Details
//        for (OrderDetailRequest dto : request.getDetails()) {
//
//            Product product = productRepository.findById(dto.getProductId())
//                    .orElseThrow(() -> new RuntimeException(
//                            "Product not found: " + dto.getProductId()
//                    ));
//
//            OrderDetail detail = new OrderDetail();
//            detail.setProduct(product);
//            detail.setUnitPrice(dto.getUnitPrice());
//            detail.setQuantity(dto.getQuantity());
//            detail.setDiscount(dto.getDiscount());
//
//            order.addDetail(detail);
//        }
//
//        // ✅ Save Order + Details (transaction)
//        Order saved = repository.save(order);
//
//        return new OrderSaveResponse(
//                "Order detail saved successfully",
//                 saved.getOrderID()
//        );
//    }
@Override
public OrderSaveResponse save(OrderRequest request) {

    Customer customer = customerRepository.findById(request.getCustomerId())
            .orElseThrow(() -> new RuntimeException("Customer not found"));

    Employee employee = employeeRepository.findById(request.getEmployeeId())
            .orElseThrow(() -> new RuntimeException("Employee not found"));

    Shipper shipper = shipperRepository.findById(request.getShipVia())
            .orElseThrow(() -> new RuntimeException("Shipper not found"));

    // MapStruct mapping
    Order order = orderMapper.toEntity(request);

    // Set relations
    order.setCustomer(customer);
    order.setEmployee(employee);
    order.setShipVia(shipper);

    order.setOrderDate(LocalDate.now());

    // Set product for each detail
    for (int i = 0; i < request.getDetails().size(); i++) {

        Integer productId = request.getDetails().get(i).getProductId();

        Product product = productRepository.findById(productId)
                .orElseThrow(() ->
                        new RuntimeException("Product not found: " + productId));

        order.getOrderDetails().get(i).setProduct(product);
    }

    Order saved = repository.save(order);

    return new OrderSaveResponse(
            "Order saved successfully",
            saved.getOrderID()
    );
}


    /**
     * @param id
     * @return
     */
    @Override
    public void deleteById(int id) {
         repository.deleteById(id);
    }

    /**
     * @param ShipName
     * @param ShipCity
     * @return
     */
    @Override
    public List<Order> findByShipNameAndShipCity(String ShipName, String ShipCity) {
        return repository.findByShipNameAndShipCity( ShipName,  ShipCity);
    }

    @Override
    public List<Order> findByShipPostalCodeContaining(String shipPostalCode) {
//        var result=repository.findByShipPostalCodeContaining(shipPostalCode);
//        return result;
        return null;
    }

    @Override
    public List<Order> findByShipName(String ShipName) {
//        var result=repository.findByShipName(ShipName);
//        return result;
        return null;
    }

//    @Override
//    public List<OrderEntity> findByCustomerID(String customerID){
//        return repository.findByCustomerID( customerID);
//    }
}
