package com.example.inditex.application.service;

import com.example.inditex.domain.exceptions.PriceNotFoundException;
import com.example.inditex.domain.model.Price;
import com.example.inditex.application.port.out.PriceRepository;
import com.example.inditex.application.port.in.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class PriceServiceImplementation implements PriceService {
    @Autowired
    private PriceRepository repository;
    @Override
    public Optional<Price> findPrice(LocalDateTime startDate, Integer productId, Integer brandId)  throws PriceNotFoundException {
        List<Price> prices = repository.findApplicablePrices(startDate, productId, brandId);

        return Optional.ofNullable(prices.stream().max(Comparator.comparing(Price::getPriority)
                .thenComparing(Price::getStartDate)).orElseThrow(() -> new PriceNotFoundException("No price found")));

    }
}
