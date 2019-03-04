package data;

public class GenericTradeData extends AbstractTradeData {

    public GenericTradeData(TradeType tradeType, double tradeVolume, int numberOfMarketOrders, double minMarketOrderPrice, double maxMarketOrderPrice) {
        super(tradeType, tradeVolume, numberOfMarketOrders, minMarketOrderPrice, maxMarketOrderPrice);
    }
}
