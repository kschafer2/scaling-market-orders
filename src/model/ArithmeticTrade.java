package model;

public class ArithmeticTrade extends SequentialTrade {

    protected ArithmeticTrade(TradeType type, int numberOfOrders, double totalVolume,
                           double minPrice, double maxPrice, double commonDifference) {

        super(type, numberOfOrders, totalVolume, minPrice, maxPrice, commonDifference);
    }

    protected ArithmeticTrade(TradeType type, int numberOfOrders, double totalVolume,
                           double minPrice, double maxPrice, double commonDifference, double percentageFee) {

        super(type, numberOfOrders, totalVolume, minPrice, maxPrice, commonDifference, percentageFee);
    }

    @Override
    double getFirstOrderVolume() {
        //derived from sum of finite arithmetic series formula: Sn=(n(2a+(n-1)d))/2
        return ((2*totalVolume/numberOfOrders)-(differenceBetweenOrders*(numberOfOrders-1)))/2;
    }

    @Override
    double getOrderVolume(MarketOrder marketOrder) {
        return marketOrder.getOrderVolume()+ differenceBetweenOrders;
    }

    @Override
    public String toString() {
        return "ArithmeticTrade{" + super.toString();
    }
}
