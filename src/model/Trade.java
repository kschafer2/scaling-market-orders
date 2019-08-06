package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Trade {

    TradeType type;
    int numberOfOrders;
    double totalVolume;
    double percentageFee;
    List<MarketOrder> marketOrders = new ArrayList<>();

    abstract void build();

    public Trade activate() {
        if(percentageFee > 0) {
            //apply the fee
            totalVolume = totalVolume/(1+(percentageFee/100));
        }
        build();

        return this;
    }

    public static ManualTrade manual(TradeType type) {
        return new ManualTrade(type);
    }

    public static ArithmeticTrade arithmetic(TradeType type, int numberOfOrders, double totalVolume,
                                   double minPrice, double maxPrice, double commonDifference) {

        return new ArithmeticTrade(type, numberOfOrders, totalVolume, minPrice, maxPrice, commonDifference);
    }

    public static ArithmeticTrade arithmetic(TradeType type, int numberOfOrders, double totalVolume,
                                   double minPrice, double maxPrice, double commonDifference,
                                   double percentageFee) {

        return new ArithmeticTrade(type, numberOfOrders, totalVolume, minPrice, maxPrice, commonDifference,
                                    percentageFee);
    }

    public static GeometricTrade geometric(TradeType type, int numberOfOrders, double totalVolume,
                                  double minPrice, double maxPrice, double commonRatio) {

        return new GeometricTrade(type, numberOfOrders, totalVolume, minPrice, maxPrice, commonRatio);
    }

    public static GeometricTrade geometric(TradeType type, int numberOfOrders, double totalVolume,
                                  double minPrice, double maxPrice, double commonRatio,
                                  double percentageFee) {

        return new GeometricTrade(type, numberOfOrders, totalVolume, minPrice, maxPrice, commonRatio,
                                    percentageFee);
    }

    @Override
    public String toString() {
        return "Trade{" +
                "type=" + type +
                ", numberOfOrders=" + numberOfOrders +
                ", totalVolume=" + totalVolume +
                ", percentageFee=" + percentageFee +
                ", marketOrders=" + marketOrders +
                '}';
    }
}
