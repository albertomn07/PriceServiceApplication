package com.example.inditex.infraestructure.web.controller;

import com.example.inditex.domain.exceptions.IncorrectParamException;
import com.example.inditex.domain.exceptions.PriceNotFoundException;
import com.example.inditex.application.port.in.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/prices")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @GetMapping("/price")
    public ResponseEntity<?> getPrice(
            @RequestParam(value = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam(value = "productId") Integer productId,
            @RequestParam(value = "brandId") Integer brandId) throws IncorrectParamException, PriceNotFoundException {

        if(startDate == null || productId == null || brandId == null){
            throw new IncorrectParamException("Some of provided params are null and cannot be null");
        }

        return priceService.findPrice(startDate, productId, brandId)
                .map(price -> ResponseEntity.ok().body(Map.of(
                        "productId", price.getProductId(),
                        "brandId", price.getBrandId(),
                        "startDate", price.getStartDate(),
                        "price", price.getPrice(),
                        "endDate", price.getEndDate())))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}