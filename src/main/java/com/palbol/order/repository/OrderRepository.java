package com.palbol.order.repository;

import com.palbol.order.domain.OrderDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderDomain, Long> {
    @Query(value = "select * from sp_createOrder(:productId, :orderQuantity, :customer_id)",
            nativeQuery = true)
    Optional<Long> createOrder
            (@Param("productId") Long productId,
             @Param("orderQuantity") Integer orderQuantity,
             @Param("customer_id") Long customer_id);

    @Query(value = "select * from sp_addOrder(:productId, :orderId, :orderQuantity)",
            nativeQuery = true)
    Optional<Long> updateOrder
            (@Param("productId") Long productId,
             @Param("orderId") Long orderId,
             @Param("orderQuantity") Integer orderQuantity);
}
