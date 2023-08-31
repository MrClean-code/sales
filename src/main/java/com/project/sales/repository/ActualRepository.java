package com.project.sales.repository;

import com.project.sales.dto.DailySalesResult;
import com.project.sales.dto.SalesPromoResult;
import com.project.sales.model.Actuals;
import com.project.sales.model.Indicator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActualRepository extends JpaRepository<Actuals, Long> {

    @Query("SELECT NEW com.project.sales.dto.SalesPromoResult(" +
            "a.customer.networkName, " +
            "a.product.category, " +
            "MONTH(a.day), " +
            "SUM(CASE WHEN a.promoIndicator = 'REGULAR'" +
            " THEN a.units " +
            " ELSE 0 END), " +
            "SUM(CASE WHEN a.promoIndicator = 'PROMO' " +
            " THEN a.units " +
            " ELSE 0 END), " +
            " SUM(CASE WHEN a.promoIndicator = 'PROMO'" +
            " THEN a.units ELSE 0 END) / CAST(SUM(a.units) AS double) * 100.0)" +
            "FROM Actuals a " +
            "WHERE (:promoIndicator IS NULL OR a.promoIndicator = :promoIndicator) " +
            "GROUP BY a.customer.networkName, a.product.category, MONTH(a.day)")
    List<SalesPromoResult> findSalesByPromo(Indicator promoIndicator);

    @Query("SELECT NEW com.project.sales.dto.DailySalesResult(" +
            "a.day, " +
            "a.customer.networkName, " +
            "a.product.productName, " +
            "a.units, " +
            "a.shipmentPrice) " +
            "FROM Actuals a " +
            "WHERE (:networks IS NULL OR a.customer.networkName IN :networks) " +
            "AND (:products IS NULL OR a.product.productName IN :products)")
    List<DailySalesResult> findDailySalesByNetworksAndProducts(List<String> networks, List<String> products);

}
