package data;

import Scalable.Scalable;

public class GeometricScalingTradeData extends AbstractTradeData implements Scalable {

    private double scalingRatio;

    public GeometricScalingTradeData(TradeType tradeType, double tradeVolume, double scalingRatio, int numberOfMarketOrders,
                                     double minMarketOrderPrice, double maxMarketOrderPrice) {

        super(tradeType, tradeVolume, numberOfMarketOrders, minMarketOrderPrice, maxMarketOrderPrice);
        this.scalingRatio = scalingRatio;
    }

    public double getScale() {
        return scalingRatio;
    }

}
