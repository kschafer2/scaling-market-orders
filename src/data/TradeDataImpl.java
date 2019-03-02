package data;

public class TradeDataImpl extends AbstractTradeData {

    public TradeDataImpl(TradeType tradeType, double tradeVolume, int numberOfMarketOrders,
                         double minMarketOrderPrice, double maxMarketOrderPrice) {

        super(tradeType, tradeVolume, numberOfMarketOrders,
                minMarketOrderPrice, maxMarketOrderPrice);
    }

}
