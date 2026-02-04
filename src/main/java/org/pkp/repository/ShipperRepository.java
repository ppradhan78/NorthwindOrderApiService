package org.pkp.repository;

import org.pkp.entity.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ShipperRepository extends JpaRepository<Shipper, Integer> {
}