package com.project.sales.service.impl;

import com.project.sales.dto.DailySalesResult;
import com.project.sales.dto.SalesPromoResult;
import com.project.sales.model.Indicator;
import com.project.sales.repository.ActualRepository;
import com.project.sales.service.ActualService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActualServiceImpl implements ActualService {

    private final ActualRepository actualRepository;

    @Override
    public List<DailySalesResult> getDailySales(List<String> networks, List<String> products) {
        return actualRepository.findDailySalesByNetworksAndProducts(networks, products);
    }

    @Override
    public List<SalesPromoResult> getSalesByPromo(Indicator promoIndicator) {
        return actualRepository.findSalesByPromo(promoIndicator);
    }
}
