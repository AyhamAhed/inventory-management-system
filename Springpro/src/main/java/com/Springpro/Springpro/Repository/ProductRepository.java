package com.Springpro.Springpro.Repository;

import com.Springpro.Springpro.Model.entity.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Integer> {
    // You can add custom query methods here if needed
}
