package com.project.sales.service.impl;

import com.project.sales.dto.PriceDto;
import com.project.sales.model.Price;
import com.project.sales.repository.PriceRepository;
import com.project.sales.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    @Override
    public List<PriceDto> getAllPrices() {
        List<PriceDto> prices = priceRepository.findPrices()
                .stream()
                .map(Price::toPriceDto)
                .collect(Collectors.toList());
        return prices;
    }

    @Override
    public Price createPrice(Price price) {
        return priceRepository.save(price);
    }

    @Override
    public PriceDto updatePrice(Long id, Price newPrice) {
        Price price = priceRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("not fount id = " + id) );

        price.setCustomer(newPrice.getCustomer());
        price.setRegularPrice(newPrice.getRegularPrice());
        price.setProduct(newPrice.getProduct());
        priceRepository.save(price);

        PriceDto priceDto = Price.toPriceDto(price);
        return priceDto;
    }

    @Override
    public String deletePrice(Long id) {
        priceRepository.deleteById(id);
        return String.format("note id = %d deleted", id);
    }
}
