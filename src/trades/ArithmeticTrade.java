package trades;

import data.TradeType;

public class ArithmeticTrade extends SequentialTrade {

    protected ArithmeticTrade(TradeType type, int totalOrders, double tradeVolume,
                           double minPrice, double maxPrice, double commonDifference) {

        super(type, totalOrders, tradeVolume, minPrice, maxPrice, commonDifference);
    }

    protected ArithmeticTrade(TradeType type, int totalOrders, double tradeVolume,
                           double minPrice, double maxPrice, double commonDifference, double fee) {

        super(type, totalOrders, tradeVolume, minPrice, maxPrice, commonDifference, fee);
    }

    @Override
    double getFirstOrderVolume() {
        //todo implement this
        return 0;
    }

    @Override
    double getNextOrderVolume(double previousVolume) {
        //todo implement this
        return 0;
    }
}
