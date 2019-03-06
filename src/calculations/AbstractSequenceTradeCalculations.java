package calculations;

import data.SeqTradeData;


public abstract class AbstractSequenceTradeCalculations implements FirstMarketOrderDependentCalculations, TradeCalculations<SeqTradeData> {

    SeqTradeData data;

    AbstractSequenceTradeCalculations(SeqTradeData data) {
        this.data = data;
    }

    @Override
    public SeqTradeData getData() {
        return data;
    }

    @Override
    public void setData(SeqTradeData data) {
        this.data = data;
    }

    @Override
    public double calculateMarketOrderPriceRange() {
        return data.getMaxMarketOrderPrice() - data.getMinMarketOrderPrice();
    }

    @Override
    public double calculateMarketOrderPriceInterval() {
            return calculateMarketOrderPriceRange()/(data.getNumberOfMarketOrders() - 1);
    }
}


