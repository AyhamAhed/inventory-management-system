package com.Springpro.Springpro.Repository;

import com.Springpro.Springpro.Model.entity.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel, Integer> {
}
