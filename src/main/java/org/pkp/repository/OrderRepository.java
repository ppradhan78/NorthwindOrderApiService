package org.pkp.repository;

import org.pkp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {


    @Query("""
   SELECT o FROM Order o JOIN FETCH o.customer  JOIN FETCH o.employee
""")
    List<Order> findAllOrder();
    //6.	 JPQL (Java Persistence Query Language)
//    @Query("FROM Customers s WHERE s.shipPostalCode  LIKE %:shipPostalCode%")
//    List<OrderEntity> findByShipPostalCodeContaining(String shipPostalCode);

    //5.	Query Methods (Derived Queries)
    List<Order> findByShipNameAndShipCity(String ShipName, String ShipCity);

    //7.	Native SQL Queries
//    @Query(value = "SELECT * FROM Orders c  WHERE c.ShipName  LIKE %:shipName%",nativeQuery = true)
//    List<OrderEntity> findByShipName(String ShipName);

   // List<OrderEntity> findByCustomerID(String customerID);

}