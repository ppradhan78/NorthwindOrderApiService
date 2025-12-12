package org.pkp.services;

import org.pkp.entity.Orders;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrdersService {
    List<Orders> findAll();
    Optional<Orders> findById(int id);
    Orders save(Orders dto);
    void deleteById(int id);

    List<Orders> findByShipPostalCodeContaining(String shipPostalCode);
    List<Orders> findByShipNameAndShipCity(String ShipName, String ShipCity)
            ;
    List<Orders> findByShipName(String ShipName);
}
