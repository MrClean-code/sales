package com.project.sales.repository;

import com.project.sales.dto.PriceDto;
import com.project.sales.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface PriceRepository extends JpaRepository<Price, Long> {
    @Query("select p " +
            "from Price p " +
            "left join fetch p.customer " +
            "left join fetch p.product ")
    Set<Price> findPrices();
}
