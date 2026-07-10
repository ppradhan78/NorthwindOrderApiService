package org.pkp.services.v2.imp;

import org.pkp.dto.v2.response.OrderResponse;
import org.pkp.entity.*;
import org.pkp.mapper.v2.FullBaseOrderMapper;
import org.pkp.mapper.v2.FullOrderMapper;
import org.pkp.mapper.v2.OrderMapper;
import org.pkp.repository.*;
import org.pkp.services.v2.LambdaStreamApiService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class LambdaStreamApiServiceImpl implements LambdaStreamApiService {

    private OrderRepository repository;
    private EmployeeRepository employeeRepository;
    private CustomerRepository customerRepository;
    private ProductRepository productRepository;
    private ShipperRepository shipperRepository;
    private final FullBaseOrderMapper fullBaseOrderMapper;
    private final FullOrderMapper fullOrderMapper;
    private final OrderMapper orderMapper;

    public LambdaStreamApiServiceImpl(OrderRepository repository, EmployeeRepository employeeRepository, CustomerRepository customerRepository,
                                      ProductRepository productRepository, ShipperRepository shipperRepository, FullBaseOrderMapper fullBaseOrderMapper, FullOrderMapper fullOrderMapper
    , OrderMapper orderMapper) {
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
    public List<OrderResponse> findAllOrder(Integer employeeID) {
        return repository.findAll()
                .stream()
                .filter(order -> order.getEmployee().getEmployeeID() == employeeID)   // lambda
                .map(this::mapToResponse)
                .toList();
    }
    @Override
    public List<OrderResponse> findAllOrder(Integer employeeID, Integer ShipVia,String ShipCity) {
        return repository.findAll()
                .stream()
                .filter(order -> order.getEmployee().getEmployeeID() == employeeID
                && order.getShipVia().getShipperID() > ShipVia && order.getShipCity()==ShipCity
                )   // lambda
                .map(this::mapToResponse)
                .toList();
    }


    @Override
    public List<OrderResponse> findAllOrderSortByShipCountryAsc(Integer employeeID) {
        return repository.findAll()
                .stream()
                .filter(order -> order.getEmployee().getEmployeeID() == employeeID)
                .sorted(Comparator.comparing(Order::getShipCountry))
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public List<OrderResponse> findAllOrderSortByShipCountryDesc(Integer employeeID) {
        return repository.findAll()
                .stream()
                .filter(order -> order.getEmployee().getEmployeeID() == employeeID)
                .sorted(Comparator.comparing(Order::getShipCountry).reversed())
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public List<OrderResponse> findAllOrderLimit(Integer limit) {
        return repository.findAll()
                .stream()
                .limit(limit)   // lambda
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public List<OrderResponse> findAllOrderSkip(Integer skip) {
        return repository.findAll()
                .stream()
                .skip(skip)   // lambda
                .map(this::mapToResponse)
                .toList();
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

}
