package com.fahmikudo.tritronik.smarthomestay.repository;

import com.fahmikudo.tritronik.smarthomestay.entity.Order;
import com.fahmikudo.tritronik.smarthomestay.entity.OrderPayment;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderPaymentRepository extends BaseRepository<OrderPayment> {

    Optional<OrderPayment> findOrderPaymentByOrder(Order order);

}
