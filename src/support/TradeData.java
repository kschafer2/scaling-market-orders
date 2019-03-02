package support;

public abstract class TradeData implements TradeDataInt {

    private TradeType tradeType;
    private int numberOfMarketOrders;
    private double tradeVolume;
    private double scalingRatio;
    private double minMarketOrderPrice;
    private double maxMarketOrderPrice;

    TradeData(TradeType tradeType, double tradeVolume, double scalingRatio, int numberOfMarketOrders,
                     double minMarketOrderPrice, double maxMarketOrderPrice) {

        this.tradeType = tradeType;
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

    public int getNumberOfMarketOrders() {
        return numberOfMarketOrders;
    }

    public double getMinMarketOrderPrice() {
        return minMarketOrderPrice;
    }

    public double getMaxMarketOrderPrice() {
        return maxMarketOrderPrice;
    }
}
