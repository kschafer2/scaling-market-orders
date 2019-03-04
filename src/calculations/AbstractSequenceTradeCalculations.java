package calculations;

import data.SequenceTradeData;

public abstract class AbstractSequenceTradeCalculations implements TradeCalculations {

    SequenceTradeData data;

    AbstractSequenceTradeCalculations(SequenceTradeData data) {
        this.data = data;
    }

    public SequenceTradeData getData() {
        return data;
    }

    public void setData(SequenceTradeData data) {
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


