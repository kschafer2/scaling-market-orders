package trades;

import orders.MarketOrder;

import java.util.List;

public abstract class AbstractTrade<T> {

    private List<MarketOrder> marketOrderList;
    private T calculations;

    public List<MarketOrder> getMarketOrderList() {
        return marketOrderList;
    }

    public void setMarketOrderList(List<MarketOrder> marketOrderList) {
        this.marketOrderList = marketOrderList;
    }

    public T getCalculations() {
        return calculations;
    }

    public void setCalculations(T calculations) {
        this.calculations = calculations;
    }
}
