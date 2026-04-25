package com.vgm.invest.domain.custody.vo;
import jakarta.persistence.Embeddable;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Embeddable
public class AveragePrice {

    private BigDecimal valueAveragePrice;

    public AveragePrice(BigDecimal valueAveragePrice) {
        this.valueAveragePrice = valueAveragePrice;
    }

    public AveragePrice calculateNewAvaregePrice(int currentQuantity, int addedQty, BigDecimal purchasePrice){
        BigDecimal totalCostAcumulated = this.valueAveragePrice.multiply(BigDecimal.valueOf(currentQuantity));
        BigDecimal newOperationCost = purchasePrice.multiply(BigDecimal.valueOf(addedQty));
        BigDecimal totalCost = totalCostAcumulated.add(newOperationCost);
        BigDecimal totalQuantity = BigDecimal.valueOf(currentQuantity+addedQty);
        BigDecimal result = totalCost.divide(totalQuantity, 4, RoundingMode.HALF_UP);
        return new AveragePrice(result);
    }
}
