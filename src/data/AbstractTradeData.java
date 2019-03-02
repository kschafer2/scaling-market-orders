package data;

public abstract class AbstractTradeData implements TradeData {

    private TradeType tradeType;
    private int numberOfMarketOrders;
    private double tradeVolume;
    private double minMarketOrderPrice;
    private double maxMarketOrderPrice;

    public AbstractTradeData(TradeType tradeType, double tradeVolume, int numberOfMarketOrders,
                             double minMarketOrderPrice, double maxMarketOrderPrice) {

        this.tradeType = tradeType;
        this.tradeVolume = tradeVolume;
        this.numberOfMarketOrders = numberOfMarketOrders;
        this.minMarketOrderPrice = minMarketOrderPrice;
        this.maxMarketOrderPrice = maxMarketOrderPrice;
    }

    @Override
    public TradeType getTradeType() {
        return tradeType;
    }

    @Override
    public double getTradeVolume() {
        return tradeVolume;
    }

    @Override
    public int getNumberOfMarketOrders() {
        return numberOfMarketOrders;
    }

    @Override
    public double getMinMarketOrderPrice() {
        return minMarketOrderPrice;
    }

    @Override
    public double getMaxMarketOrderPrice() {
        return maxMarketOrderPrice;
    }
}
