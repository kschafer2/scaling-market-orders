package calculations;

import data.AbstractTradeData;

public abstract class AbstractTradeCalculations implements TradeCalculations {

    AbstractTradeData data;

    AbstractTradeCalculations(AbstractTradeData data) {
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


