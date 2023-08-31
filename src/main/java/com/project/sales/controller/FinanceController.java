package com.project.sales.controller;

import com.project.sales.dto.PriceDto;
import com.project.sales.model.Price;
import com.project.sales.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/finance")
@RequiredArgsConstructor
public class FinanceController {
    private final PriceService priceService;

    @GetMapping("/prices")
    public List<PriceDto> getAllPrices() {
        return priceService.getAllPrices();
    }

    @PostMapping("/prices")
    public Price createPrice(@RequestBody Price price) {
        return priceService.createPrice(price);
    }

    @PutMapping("/prices/{id}")
    public PriceDto updatePrice(@PathVariable Long id, @RequestBody Price newPrice) {
        return priceService.updatePrice(id, newPrice);
    }

    @DeleteMapping("/prices/{id}")
    public String deletePrice(@PathVariable Long id) {
        return priceService.deletePrice(id);
    }
}
