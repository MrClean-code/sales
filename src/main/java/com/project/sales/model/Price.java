package com.project.sales.model;


import com.project.sales.dto.PriceDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "price")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    private double regularPrice;

    public static PriceDto toPriceDto(Price price) {
        PriceDto priceDto = new PriceDto();

        priceDto.setRegularPrice(price.getRegularPrice());
        priceDto.setProduct(price.getProduct());
        priceDto.setCustomer(price.getCustomer());

        return priceDto;
    }
}