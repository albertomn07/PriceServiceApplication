package com.example.inditex.application.port.out;

import com.example.inditex.domain.model.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository {
    List<Price> findApplicablePrices(LocalDateTime startDate, int productId, int brandId);
}
