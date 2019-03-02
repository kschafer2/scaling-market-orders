package support;

public class TradeDataImpl extends TradeData {

    public TradeDataImpl(TradeType tradeType, double tradeVolume, double scalingRatio, int numberOfMarketOrders,
                         double minMarketOrderPrice, double maxMarketOrderPrice) {

        super(tradeType, tradeVolume, scalingRatio, numberOfMarketOrders,
                minMarketOrderPrice, maxMarketOrderPrice);
    }
}
