package com.example.inditex.service;

import com.example.inditex.domain.exceptions.PriceNotFoundException;
import com.example.inditex.domain.model.Price;
import com.example.inditex.application.port.out.PriceRepository;
import com.example.inditex.application.service.PriceServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

class PriceServiceTest {

    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    private PriceServiceImplementation priceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenFindPriceWithValidParametersThenReturnPrice() throws PriceNotFoundException {
        LocalDateTime testStartDate = LocalDateTime.of(2020, 6, 14, 10, 0);
        Price expectedPrice = new Price();
        when(priceRepository.findApplicablePrices(eq(testStartDate), eq(35455), eq(1)))
                .thenReturn(Arrays.asList(expectedPrice));
        Optional<Price> result = priceService.findPrice(testStartDate, 35455, 1);
        assertTrue(result.isPresent());
        assertEquals(expectedPrice, result.get());
    }

    @Test
    void whenFindPriceAndNoPriceFoundThenThrowException() {
        LocalDateTime testStartDate = LocalDateTime.of(2020, 6, 14, 9, 0);
        when(priceRepository.findApplicablePrices(eq(testStartDate), eq(35455), eq(1)))
                .thenReturn(Arrays.asList());
        Exception exception = assertThrows(
                PriceNotFoundException.class,
                () -> priceService.findPrice(testStartDate, 35455, 1));
        assertEquals("No price found", exception.getMessage());
    }


}

