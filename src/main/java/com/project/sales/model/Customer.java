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
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private String networkName;

//    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
//    private List<Actuals> actuals = new ArrayList<>();
//
//    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
//    private List<Price> prices = new ArrayList<>();
}
