package org.pkp.services.imp;

import lombok.RequiredArgsConstructor;
import org.pkp.entity.Orders;
import org.pkp.repository.OrdersRepository;
import org.pkp.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository repository;

    /**
     * @return
     */
    @Override
    public List<Orders> findAll() {
        return repository.findAll();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<Orders> findById(int id) {
        return repository.findById(id);
    }

    /**
     * @param dto
     * @return
     */
    @Override
    public Orders save(Orders dto) {
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
    public List<Orders> findByShipNameAndShipCity(String ShipName, String ShipCity) {
        return repository.findByShipNameAndShipCity( ShipName,  ShipCity);
    }

    @Override
    public List<Orders> findByShipPostalCodeContaining(String shipPostalCode) {
//        var result=repository.findByShipPostalCodeContaining(shipPostalCode);
//        return result;
        return null;
    }

    @Override
    public List<Orders> findByShipName(String ShipName) {
//        var result=repository.findByShipName(ShipName);
//        return result;
        return null;
    }
}
