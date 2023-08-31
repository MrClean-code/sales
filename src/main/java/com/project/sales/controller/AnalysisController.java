package com.project.sales.controller;

import com.project.sales.dto.DailySalesResult;
import com.project.sales.dto.SalesPromoResult;
import com.project.sales.model.Indicator;
import com.project.sales.service.ActualService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/analysis")
@RequiredArgsConstructor
public class AnalysisController {

    private final ActualService actualService;

    @GetMapping("/sales")
    public List<SalesPromoResult> getSalesByPromo(
            @RequestParam(value = "promoIndicator", required = false) Indicator promoIndicator) {
        return actualService.getSalesByPromo(promoIndicator);
    }

    @GetMapping("/everyday")
    public List<DailySalesResult> getDailySales(
            @RequestParam(value = "networks", required = false) List<String> networks,
            @RequestParam(value = "products", required = false) List<String> products) {

        return actualService.getDailySales(networks, products);
    }

}
