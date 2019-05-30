package data;

public class SequenceTradeData extends GenericTradeData implements SeqTradeData {

    private double functionCoefficient;

    public SequenceTradeData(TradeType tradeType, double tradeVolume, double functionCoefficient,
                             int numberOfMarketOrders, double minMarketOrderPrice, double maxMarketOrderPrice) {

        super(tradeType, tradeVolume, numberOfMarketOrders, minMarketOrderPrice, maxMarketOrderPrice);
        this.functionCoefficient = functionCoefficient;
    }

    @Override
    public double getFunctionCoefficient() {
        return functionCoefficient;
    }

    @Override
    public void setFunctionCoefficient(double functionCoefficient) {
        this.functionCoefficient = functionCoefficient;
    }
}
