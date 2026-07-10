package org.pkp.repository;

import org.pkp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("""
   SELECT o FROM Order o JOIN FETCH o.customer  JOIN FETCH o.employee
""")
    List<Order> findAllOrder();

    // Derived query (best)
    List<Order> findByShipPostalCodeContaining(String shipPostalCode);

    //5.	Query Methods (Derived Queries)
    List<Order> findByShipNameContainingIgnoreCaseAndShipCityContainingIgnoreCase(
            String shipName,
            String shipCity
    );
    // Native query is fine
    @Query(
            value = "SELECT * FROM Orders c WHERE c.ShipName LIKE %:shipName%",
            nativeQuery = true
    )
    List<Order> findByShipName(@Param("shipName") String shipName);

    @Query("""
    SELECT o FROM Order o
    WHERE o.customer.customerID = :customerId
""")
    List<Order> findByCustomerId(@Param("customerId") String customerId);


}