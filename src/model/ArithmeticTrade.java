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
    BigDecimal getOrderVolumeAtIndex(int index) {
        //todo handle exception better
        if(index < 0 || index > numberOfOrders) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if(index == 0) {
            BigDecimal two = new BigDecimal("2");
            BigDecimal bigNumberOfOrders = new BigDecimal(String.valueOf(numberOfOrders));

            BigDecimal minuend = two.multiply(totalVolume).divide(bigNumberOfOrders, HALF_DOWN);
            BigDecimal subtrahend = differenceBetweenOrders.multiply(bigNumberOfOrders.subtract(ONE));

            return (minuend.subtract(subtrahend))
                    .divide(two, HALF_DOWN);
        }

        return marketOrders.get(index-1).getOrderVolume().add(differenceBetweenOrders);
    }

    @Override
    public String toString() {
        return "ArithmeticTrade{" + super.toString();
    }
}
