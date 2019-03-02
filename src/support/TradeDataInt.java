package support;

public interface TradeDataInt {

    TradeType getTradeType();

    double getTradeVolume();

    int getNumberOfMarketOrders();

    double getMinMarketOrderPrice();

    double getMaxMarketOrderPrice();
}
