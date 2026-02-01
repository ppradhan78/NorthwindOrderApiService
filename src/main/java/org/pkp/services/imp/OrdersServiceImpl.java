package org.pkp.services.imp;

import lombok.RequiredArgsConstructor;
import org.pkp.dto.Response.AllOrderResponse;
import org.pkp.dto.Response.OrderResponse;
import org.pkp.entity.Order;
import org.pkp.mapper.AllOrderMapper;
import org.pkp.mapper.OrderMapper;
import org.pkp.repository.OrderRepository;
import org.pkp.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrdersService {

    private OrderRepository repository;
    private final OrderMapper mapper;
    private final AllOrderMapper allOrderMapper;

    public OrdersServiceImpl(OrderRepository repository,
                             OrderMapper mapper,AllOrderMapper allOrderMapper) {
        this.repository = repository;
        this.mapper = mapper;
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
            return mapper.toResponseList(repository.findAll());
      }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<OrderResponse> findById(int id) {
        return repository.findById(id)
                .map(mapper::toResponse);
    }

    /**
     * @param dto
     * @return
     */
    @Override
    public Order save(Order dto) {
        return repository.save(dto);
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
