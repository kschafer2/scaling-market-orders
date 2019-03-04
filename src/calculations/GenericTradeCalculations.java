package calculations;

import data.GenericTradeData;

public class GenericTradeCalculations implements TradeCalculations {

    GenericTradeData data;

    @Override
    public double calculateMarketOrderPriceRange() {
        return data.getMaxMarketOrderPrice() - data.getMinMarketOrderPrice();
    }

    @Override
    public double calculateMarketOrderPriceInterval() {
        return calculateMarketOrderPriceRange()/(data.getNumberOfMarketOrders() - 1);
    }
}
