package model;

public class ArithmeticTrade extends SequentialTrade {

    protected ArithmeticTrade(TradeType type, int totalOrders, double tradeVolume,
                           double minPrice, double maxPrice, double commonDifference) {

        super(type, totalOrders, tradeVolume, minPrice, maxPrice, commonDifference);
    }

    protected ArithmeticTrade(TradeType type, int totalOrders, double tradeVolume,
                           double minPrice, double maxPrice, double commonDifference, double percentageFee) {

        super(type, totalOrders, tradeVolume, minPrice, maxPrice, commonDifference, percentageFee);
    }

    @Override
    double getFirstOrderVolume() {
        //derived from sum of finite arithmetic series formula: Sn=(n(2a+(n-1)d))/2
        return ((2*tradeVolume/totalOrders)-(difference*(totalOrders-1)))/2;
    }

    @Override
    double getOrderVolume(MarketOrder marketOrder) {
        return marketOrder.getTradeVolume()+difference;
    }
}
