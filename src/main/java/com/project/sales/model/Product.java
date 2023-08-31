package com.project.sales.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productCode;
    private String productName;
    private String category;
    private String brand;

//    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
//    private List<Actuals> actuals = new ArrayList<>();
//
//    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
//    private List<Price> prices = new ArrayList<>();
}
