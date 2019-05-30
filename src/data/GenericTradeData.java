package data;

public class GenericTradeData implements TradeData {

    private TradeType tradeType;
    private int numberOfMarketOrders;
    private double tradeVolume;
    private double minMarketOrderPrice;
    private double maxMarketOrderPrice;

    public GenericTradeData(TradeType tradeType, double tradeVolume, int numberOfMarketOrders,
                            double minMarketOrderPrice, double maxMarketOrderPrice) {

        this.tradeType = tradeType;
        this.tradeVolume = tradeVolume;
        this.numberOfMarketOrders = numberOfMarketOrders;
        this.minMarketOrderPrice = minMarketOrderPrice;
        this.maxMarketOrderPrice = maxMarketOrderPrice;
    }

    public void setTradeType(TradeType tradeType) {
        this.tradeType = tradeType;
    }

    @Override
    public TradeType getTradeType() {
        return tradeType;
    }

    @Override
    public int getNumberOfMarketOrders() {
        return numberOfMarketOrders;
    }

    @Override
    public void setNumberOfMarketOrders(int numberOfMarketOrders) {
        this.numberOfMarketOrders = numberOfMarketOrders;
    }

    @Override
    public double getTradeVolume() {
        return tradeVolume;
    }

    @Override
    public void setTradeVolume(double tradeVolume) {
        this.tradeVolume = tradeVolume;
    }

    @Override
    public double getMinMarketOrderPrice() {
        return minMarketOrderPrice;
    }

    @Override
    public void setMinMarketOrderPrice(double minMarketOrderPrice) {
        this.minMarketOrderPrice = minMarketOrderPrice;
    }

    @Override
    public double getMaxMarketOrderPrice() {
        return maxMarketOrderPrice;
    }

    @Override
    public void setMaxMarketOrderPrice(double maxMarketOrderPrice) {
        this.maxMarketOrderPrice = maxMarketOrderPrice;
    }
}
