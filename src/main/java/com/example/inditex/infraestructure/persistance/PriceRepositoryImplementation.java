package com.example.inditex.infraestructure.persistance;

import com.example.inditex.application.port.out.PriceRepository;
import com.example.inditex.domain.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepositoryImplementation extends JpaRepository<Price, Long>, PriceRepository {

    @Query(value = "SELECT * FROM Prices p " +
            "WHERE p.start_date <= :startDate " +
            "AND p.end_date >= :startDate " +
            "AND p.product_id = :productId " +
            "AND p.brand_id = :brandId " +
            "ORDER BY p.priority DESC",
            nativeQuery = true)
    List<Price> findApplicablePrices(LocalDateTime startDate, int productId, int brandId);
}
