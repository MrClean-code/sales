package com.project.sales.service;

import com.project.sales.dto.DailySalesResult;
import com.project.sales.dto.SalesPromoResult;
import com.project.sales.model.Indicator;

import java.util.List;

public interface ActualService {
    List<DailySalesResult> getDailySales(List<String> networks, List<String> products);

    List<SalesPromoResult> getSalesByPromo(Indicator promoIndicator);
}
