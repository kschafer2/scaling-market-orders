package factories;

import model.TradeType;
import model.fees.AbstractFee;
import model.trades.ArithmeticTrade;
import model.trades.GeometricTrade;
import model.trades.ManualTrade;

public class TradeFactory {

    public static ManualTrade manual(TradeType type) {
        return new ManualTrade(type);
    }

    public static ArithmeticTrade arithmetic(TradeType type,
                                             int numberOfOrders,
                                             double totalVolume,
                                             double minPrice,
                                             double maxPrice,
                                             double commonDifference) {
        return new ArithmeticTrade( type,
                                    numberOfOrders,
                                    totalVolume,
                                    minPrice,
                                    maxPrice,
                                    commonDifference);
    }

    public static ArithmeticTrade arithmetic(TradeType type,
                                             int numberOfOrders,
                                             double totalVolume,
                                             double minPrice,
                                             double maxPrice,
                                             double commonDifference,
                                             AbstractFee fee) {
        return new ArithmeticTrade( type,
                                    numberOfOrders,
                                    totalVolume,
                                    minPrice,
                                    maxPrice,
                                    commonDifference,
                                    fee);
    }

    public static GeometricTrade geometric(TradeType type,
                                           int numberOfOrders,
                                           double totalVolume,
                                           double minPrice,
                                           double maxPrice,
                                           double commonRatio) {
        return new GeometricTrade(  type,
                                    numberOfOrders,
                                    totalVolume,
                                    minPrice,
                                    maxPrice,
                                    commonRatio);
    }

    public static GeometricTrade geometric(TradeType type,
                                           int numberOfOrders,
                                           double totalVolume,
                                           double minPrice,
                                           double maxPrice,
                                           double commonRatio,
                                           AbstractFee fee) {
        return new GeometricTrade(  type,
                                    numberOfOrders,
                                    totalVolume,
                                    minPrice,
                                    maxPrice,
                                    commonRatio,
                                    fee);
    }
}
