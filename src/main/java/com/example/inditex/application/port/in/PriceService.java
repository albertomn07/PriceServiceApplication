package com.example.inditex.application.port.in;

import com.example.inditex.domain.exceptions.PriceNotFoundException;
import com.example.inditex.domain.model.Price;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public interface PriceService {

    public Optional<Price> findPrice(LocalDateTime startDate, Integer productId, Integer brandId) throws PriceNotFoundException;

}
