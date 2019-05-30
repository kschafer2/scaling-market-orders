package data;

public interface TradeData {

    TradeType getTradeType();

    void setTradeType(TradeType tradeType);

    double getTradeVolume();

    void setTradeVolume(double tradeVolume);

    int getNumberOfMarketOrders();

    void setNumberOfMarketOrders(int numberOfMarketOrders);

    double getMinMarketOrderPrice();

    void setMinMarketOrderPrice(double minMarketOrderPrice);

    double getMaxMarketOrderPrice();

    void setMaxMarketOrderPrice(double maxMarketOrderPrice);
}
