package data;

public interface TradeData {

    TradeType getTradeType();

    double getTradeVolume();

    int getNumberOfMarketOrders();

    double getMinMarketOrderPrice();

    double getMaxMarketOrderPrice();
}
