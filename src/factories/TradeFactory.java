package factories;

import model.ArithmeticTrade;
import model.GeometricTrade;
import model.ManualTrade;
import model.TradeType;

public class TradeFactory {

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
}
