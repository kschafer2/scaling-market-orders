package support;

public abstract class TradeCalculations implements FirstMarketOrderCalculations, NextMarketOrderCalculations {

    TradeData data;

    TradeCalculations(TradeData data) {
        this.data = data;
    }

    double calculateMarketOrderPriceRange() {
        return data.getMaxMarketOrderPrice() - data.getMinMarketOrderPrice();
    }

    double calculateMarketOrderPriceInterval() {
        if(data.getTradeType() == TradeType.BUY)
            return (calculateMarketOrderPriceRange()/(data.getNumberOfMarketOrders() - 1)) / (-1);

        else
            return calculateMarketOrderPriceRange()/(data.getNumberOfMarketOrders() - 1);
    }
}


