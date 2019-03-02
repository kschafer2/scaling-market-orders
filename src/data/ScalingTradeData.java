package data;

public class ScalingTradeData extends TradeData {

    private double scalingRatio;

    public ScalingTradeData(TradeType tradeType, double tradeVolume, double scalingRatio, int numberOfMarketOrders,
                            double minMarketOrderPrice, double maxMarketOrderPrice) {

        super(tradeType, tradeVolume, scalingRatio, numberOfMarketOrders, minMarketOrderPrice, maxMarketOrderPrice);
    }

    public double getScalingRatio() {
        return scalingRatio;
    }

}
