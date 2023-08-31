package com.project.sales.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesPromoResult {
    private String networkName;
    private String category;
    private int month;
    private long regularSales;
    private long promoSales;
    private double promoSalesPercentage;


}
