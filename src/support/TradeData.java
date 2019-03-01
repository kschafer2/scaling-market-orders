package support;

public abstract class TradeData {

    private TradeType tradeType;
    private double tradeVolume;
    private double scalingRatio;
    private double numberOfMarketOrders;
    private double minMarketOrderPrice;
    private double maxMarketOrderPrice;

    public TradeData(double tradeVolume, double scalingRatio, double numberOfMarketOrders,
                     double minMarketOrderPrice, double maxMarketOrderPrice) {

        this.tradeVolume = tradeVolume;
        this.scalingRatio = scalingRatio;
        this.numberOfMarketOrders = numberOfMarketOrders;
        this.minMarketOrderPrice = minMarketOrderPrice;
        this.maxMarketOrderPrice = maxMarketOrderPrice;
    }

    public TradeType getTradeType() {
        return tradeType;
    }

    public double getTradeVolume() {
        return tradeVolume;
    }

    public double getScalingRatio() {
        return scalingRatio;
    }

    public double getNumberOfMarketOrders() {
        return numberOfMarketOrders;
    }

    public double getMinMarketOrderPrice() {
        return minMarketOrderPrice;
    }

    public double getMaxMarketOrderPrice() {
        return maxMarketOrderPrice;
    }
}
