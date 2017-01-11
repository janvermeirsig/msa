package com.xebia.fulfillment.v2.repositories;

import com.xebia.fulfillment.v2.domain.Shipment;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ShipmentRepository extends CrudRepository<Shipment, UUID> {
}
