package com.xebia.payment.v2.repositories;

import com.xebia.payment.v2.domain.Clerk;
import com.xebia.payment.v2.domain.Payment;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ClerkRepository extends CrudRepository<Clerk, UUID> {
    Clerk findByPayment(Payment payment);
}
