package calculations;

import data.SeqTradeData;


public abstract class AbstractSequenceTradeCalculations implements TradeCalculations {

    SeqTradeData data;

    AbstractSequenceTradeCalculations(SeqTradeData data) {
        this.data = data;
    }

    public SeqTradeData getData() {
        return data;
    }

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


