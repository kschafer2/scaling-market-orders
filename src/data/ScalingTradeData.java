package data;

public class ScalingTradeData extends AbstractTradeData {

    private double scalingRatio;

    public ScalingTradeData(TradeType tradeType, double tradeVolume, double scalingRatio, int numberOfMarketOrders,
                            double minMarketOrderPrice, double maxMarketOrderPrice) {

        super(tradeType, tradeVolume, numberOfMarketOrders, minMarketOrderPrice, maxMarketOrderPrice);
        this.scalingRatio = scalingRatio;
    }

    public double getScalingRatio() {
        return scalingRatio;
    }

}
