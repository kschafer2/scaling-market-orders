package model;

import java.math.BigDecimal;

public class GeometricTrade extends SequentialTrade {

    protected GeometricTrade(TradeType type, int numberOfOrders, double totalVolume,
                     double minPrice, double maxPrice, double commonRatio) {

        super(type, numberOfOrders, totalVolume, minPrice, maxPrice, commonRatio);
    }

    protected GeometricTrade(TradeType type, int numberOfOrders, double totalVolume,
                     double minPrice, double maxPrice, double commonRatio, double percentageFee) {

        super(type, numberOfOrders, totalVolume, minPrice, maxPrice, commonRatio, percentageFee);
    }

    @Override
    double getFirstOrderVolume() {
        //split totalVolume evenly to each marketOrder if common ratio is 1
        if(new BigDecimal(differenceBetweenOrders).compareTo(new BigDecimal(1)) == 0) {
            return totalVolume /numberOfOrders;
        }

        //derived from sum of finite geometric series formula: Sn=a1(1-rn)1-r, r!=1
        return (totalVolume *(1- differenceBetweenOrders))/(1-Math.pow(differenceBetweenOrders, numberOfOrders));
    }

    @Override
    double getOrderVolume(MarketOrder marketOrder) {
        return marketOrder.getOrderVolume()* differenceBetweenOrders;
    }

    @Override
    public String toString() {
        return "GeometricTrade{" + super.toString();
    }
}
