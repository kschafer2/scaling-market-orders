package model;

public class GeometricTrade extends SequentialTrade {

    protected GeometricTrade(TradeType type, int totalOrders, double tradeVolume,
                     double minPrice, double maxPrice, double commonRatio) {

        super(type, totalOrders, tradeVolume, minPrice, maxPrice, commonRatio);
    }

    protected GeometricTrade(TradeType type, int totalOrders, double tradeVolume,
                     double minPrice, double maxPrice, double commonRatio, double percentageFee) {

        super(type, totalOrders, tradeVolume, minPrice, maxPrice, commonRatio, percentageFee);
    }

    @Override
    double getFirstOrderVolume() {

        //split tradeVolume evenly to each marketOrder if common ratio is 1
        if(difference == 1) {
            return tradeVolume/totalOrders;
        }

        //derived from sum of finite geometric series formula: Sn=a1(1-rn)1-r, r!=1
        return (tradeVolume*(1-difference))/(1-Math.pow(difference, totalOrders));
    }

    @Override
    double getOrderVolume(MarketOrder marketOrder) {
        return marketOrder.getTradeVolume()*difference;
    }
}
