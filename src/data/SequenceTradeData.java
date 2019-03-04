package data;

import trades.Sequenceable;

public class SequenceTradeData extends GenericTradeData implements Sequenceable {

    private double differenceBetween;

    public SequenceTradeData(TradeType tradeType, double tradeVolume, double differenceBetween, int numberOfMarketOrders,
                             double minMarketOrderPrice, double maxMarketOrderPrice) {

        super(tradeType, tradeVolume, numberOfMarketOrders, minMarketOrderPrice, maxMarketOrderPrice);
        this.differenceBetween = differenceBetween;
    }

    public double getDifferenceBetween() {
        return differenceBetween;
    }

}
