package model;

import java.math.BigDecimal;

import static java.math.BigDecimal.ONE;
import static java.math.RoundingMode.HALF_DOWN;

public class ArithmeticTrade extends SequentialTrade {

    public ArithmeticTrade(TradeType type, int numberOfOrders, double totalVolume,
                           double minPrice, double maxPrice, double commonDifference) {

        super(type, numberOfOrders, totalVolume, minPrice, maxPrice, commonDifference);
    }

    public ArithmeticTrade(TradeType type, int numberOfOrders, double totalVolume,
                           double minPrice, double maxPrice, double commonDifference, Fee fee) {

        super(type, numberOfOrders, totalVolume, minPrice, maxPrice, commonDifference, fee);
    }

    @Override
    BigDecimal getFirstOrderVolume() {
        //derived from sum of finite arithmetic series formula: Sn=(n(2a+(n-1)d))/2
        BigDecimal two = new BigDecimal("2");
        BigDecimal bigNumberOfOrders = new BigDecimal(String.valueOf(numberOfOrders));

        BigDecimal minuend = two.multiply(totalVolume).divide(bigNumberOfOrders, HALF_DOWN);
        BigDecimal subtrahend = differenceBetweenOrders.multiply(bigNumberOfOrders.subtract(ONE));

        return (minuend.subtract(subtrahend))
                .divide(two, HALF_DOWN);
    }

    @Override
    BigDecimal getOrderVolume(MarketOrder marketOrder) {
        return marketOrder.getOrderVolume().add(differenceBetweenOrders);
    }

    @Override
    public String toString() {
        return "ArithmeticTrade{" + super.toString();
    }
}
