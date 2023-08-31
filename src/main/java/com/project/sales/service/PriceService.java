package com.project.sales.service;

import com.project.sales.dto.PriceDto;
import com.project.sales.model.Price;

import java.util.List;

public interface PriceService {

    List<PriceDto> getAllPrices();

    Price createPrice(Price price);

    PriceDto updatePrice(Long id, Price newPrice);

    String deletePrice(Long id);
}
