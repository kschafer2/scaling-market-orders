package model;

import java.math.BigDecimal;

import static java.math.BigDecimal.ONE;
import static java.math.RoundingMode.HALF_DOWN;

public class GeometricTrade extends SequentialTrade {

    //maximum number of decimal points in desired currency
    private final int CURRENCY_SCALE = 2;

    public GeometricTrade(TradeType type, int numberOfOrders, double totalVolume,
                          double minPrice, double maxPrice, double commonRatio) {

        super(type, numberOfOrders, totalVolume, minPrice, maxPrice, commonRatio);
    }

    public GeometricTrade(TradeType type, int numberOfOrders, double totalVolume,
                          double minPrice, double maxPrice, double commonRatio, Fee fee) {

        super(type, numberOfOrders, totalVolume, minPrice, maxPrice, commonRatio, fee);
    }

    @Override
    BigDecimal getFirstOrderVolume() {

        //split totalVolume evenly to each marketOrder if common ratio is 1
        if(differenceBetweenOrders.compareTo(ONE) == 0) {

            return totalVolume.divide(new BigDecimal(String.valueOf(numberOfOrders)), HALF_DOWN)
                    .setScale(CURRENCY_SCALE, HALF_DOWN);
        }

        //derived from sum of finite geometric series formula: Sn=a1(1-rn)1-r, r!=1
        BigDecimal dividend = totalVolume.multiply(ONE.subtract(differenceBetweenOrders));
        BigDecimal divisor = ONE.subtract((differenceBetweenOrders.pow(numberOfOrders)));

        return dividend.divide(divisor, HALF_DOWN)
                .setScale(CURRENCY_SCALE, HALF_DOWN);
    }

    @Override
    BigDecimal getOrderVolume(MarketOrder marketOrder) {
        return marketOrder.getOrderVolume().multiply(differenceBetweenOrders)
                .setScale(CURRENCY_SCALE, HALF_DOWN);
    }

    @Override
    public String toString() {
        return "GeometricTrade{" + super.toString();
    }
}
