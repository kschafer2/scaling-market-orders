package trades;

import calculations.SeqTradeCalculations;
import orders.MarketOrder;

import java.util.List;

public abstract class AbstractGeometricSequenceTrade implements Buildable, UniqueFirstMarketOrder, MutableMarketOrders {

    List<MarketOrder> marketOrderList;
    SeqTradeCalculations calculations;

    public AbstractGeometricSequenceTrade(List<MarketOrder> marketOrderList,
                                          SeqTradeCalculations calculations) {

        this.marketOrderList = marketOrderList;
        this.calculations = calculations;
    }

    /*  public AbstractGeometricSequenceTrade(SeqTradeData data) {
            calculations = new GeometricSequenceTradeCalculations(data);
            marketOrderList = new ArrayList<>();
        }
    */
    public List<MarketOrder> getMarketOrderList() {
        return marketOrderList;
    }
}
