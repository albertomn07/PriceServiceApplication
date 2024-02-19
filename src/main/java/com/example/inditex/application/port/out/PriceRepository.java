package com.example.inditex.application.port.out;

import com.example.inditex.domain.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository {
    List<Price> findApplicablePrices(LocalDateTime startDate, int productId, int brandId);
}
