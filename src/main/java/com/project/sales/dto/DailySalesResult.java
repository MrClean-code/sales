package com.project.sales.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DailySalesResult {
    private Date day;
    private String networkName;
    private String productName;
    private int units;
    private double shipmentPrice;
}
