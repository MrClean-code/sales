package com.project.sales.dto;

import com.project.sales.model.Customer;
import com.project.sales.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceDto {

    private Customer customer;
    private Product product;
    private double regularPrice;
}
