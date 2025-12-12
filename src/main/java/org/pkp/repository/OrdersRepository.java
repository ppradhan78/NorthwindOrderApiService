package org.pkp.repository;

import org.pkp.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    //6.	 JPQL (Java Persistence Query Language)
//    @Query("FROM Customers s WHERE s.shipPostalCode  LIKE %:shipPostalCode%")
//    List<Orders> findByShipPostalCodeContaining(String shipPostalCode);

    //5.	Query Methods (Derived Queries)
    List<Orders> findByShipNameAndShipCity(String ShipName, String ShipCity);

    //7.	Native SQL Queries
//    @Query(value = "SELECT * FROM Orders c  WHERE c.ShipName  LIKE %:shipName%",nativeQuery = true)
//    List<Orders> findByShipName(String ShipName);

}