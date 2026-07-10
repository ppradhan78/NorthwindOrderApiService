package org.pkp.services.v2.imp;

import org.pkp.dto.v2.request.OrderRequest;
import org.pkp.dto.v2.response.FullBaseOrderResponse;
import org.pkp.dto.v2.response.OrderResponse;
import org.pkp.dto.v2.response.OrderSaveResponse;
import org.pkp.entity.*;
import org.pkp.mapper.v2.FullBaseOrderMapper;
import org.pkp.mapper.v2.FullOrderMapper;
import org.pkp.mapper.v2.OrderMapper;
import org.pkp.repository.*;
import org.pkp.services.v2.OrdersService;
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
    private final FullBaseOrderMapper fullBaseOrderMapper;
    private final FullOrderMapper fullOrderMapper;
    private final OrderMapper orderMapper;

    public OrdersServiceImpl(OrderRepository repository, EmployeeRepository employeeRepository, CustomerRepository customerRepository,
                             ProductRepository productRepository, ShipperRepository shipperRepository, FullBaseOrderMapper fullBaseOrderMapper, FullOrderMapper fullOrderMapper
    ,OrderMapper orderMapper) {
        this.repository = repository;
        this.customerRepository=customerRepository;
        this.employeeRepository=employeeRepository;
        this.productRepository=productRepository;
        this.shipperRepository=shipperRepository;
        this.fullBaseOrderMapper = fullBaseOrderMapper;
        this.fullOrderMapper = fullOrderMapper;
        this.orderMapper=orderMapper;
    }
    @Override
    public List<FullBaseOrderResponse> findAllOrder() {
        var result=repository.findAllOrder().subList(0, 2);;
        return fullOrderMapper.toAllOrderResponseList(
                result
        );
    }


//    @Override
//    public List<OrderResponse> findAll() {
//      return  orderMapper.toResponseList(repository.findAll());
//      }

    public List<OrderResponse> findAll_Steem_Lambda() {
        return  orderMapper.toResponseList(repository.findAll());
    }

    private OrderResponse mapToResponse(Order order) {
        OrderResponse res = new OrderResponse();
        res.setOrderId(order.getOrderID());
        res.setCustomerId(order.getCustomer().getCustomerID());
        res.setEmployeeId(order.getEmployee().getEmployeeID());
        res.setShipVia(order.getShipVia().getShipperID());
        res.setOrderDate(order.getOrderDate());
        res.setFreight(order.getFreight());
        res.setShipName(order.getShipName());
        res.setShipAddress(order.getShipAddress());
        res.setShipCity(order.getShipCity());
        res.setShipRegion(order.getShipRegion());
        res.setShipPostalCode(order.getShipPostalCode());
        res.setShipCountry(order.getShipCountry());
        return res;
    }
//@Override
//public List<OrderResponse> findAll() {
//    return repository.findAll()
//            .stream()
//            .map(this::mapToResponse)
//            .toList();
//}

    @Override
    public List<OrderResponse> findAll() {
        return repository.findAll()
                .stream()
                .filter(order -> order.getShipRegion() != null)   // lambda
                .map(this::mapToResponse)
                .sorted((o1, o2) -> o2.getEmployeeId().compareTo(o1.getEmployeeId())) // lambda
                .distinct()
                .toList();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<OrderResponse> findById(Integer id) {
        return repository.findById(id)
                .map(orderMapper::toResponse);
    }


@Override
public OrderSaveResponse save(OrderRequest request) {

    Customer customer = customerRepository.findById(request.getCustomerId())
            .orElseThrow(() -> new RuntimeException("Customer not found"));

    Employee employee = employeeRepository.findById(request.getEmployeeId())
            .orElseThrow(() -> new RuntimeException("Employee not found"));

    Shipper shipper = shipperRepository.findById(request.getShipVia())
            .orElseThrow(() -> new RuntimeException("Shipper not found"));

    // MapStruct mapping
    Order order = fullBaseOrderMapper.toEntity(request);

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
    public List<OrderResponse> findByShipNameAndShipCity(String ShipName, String ShipCity) {
        return orderMapper.toResponseList(repository.findByShipNameContainingIgnoreCaseAndShipCityContainingIgnoreCase( ShipName,  ShipCity));
    }

    @Override
    public List<OrderResponse> findByShipPostalCodeContaining(String shipPostalCode) {
        return  orderMapper.toResponseList(repository.findByShipPostalCodeContaining(shipPostalCode));
    }

    @Override
    public List<OrderResponse> findByShipName(String ShipName) {
        return  orderMapper.toResponseList(repository.findByShipName(ShipName));

    }

    @Override
    public List<OrderResponse> findByCustomerID(String customerID){
        return orderMapper.toResponseList(repository.findByCustomerId( customerID));
    }
}
