package trades;

import calculations.GeometricSequenceTradeCalculations;
import calculations.SeqTradeCalculations;
import data.SeqTradeData;
import orders.MarketOrder;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGeometricSequenceTrade implements Buildable, UniqueFirstMarketOrder, MutableMarketOrders {

    List<MarketOrder> marketOrderList;
    SeqTradeCalculations calculations;

    public AbstractGeometricSequenceTrade(SeqTradeData data) {
        calculations = new GeometricSequenceTradeCalculations(data);
        marketOrderList = new ArrayList<>();
    }

    public List<MarketOrder> getMarketOrderList() {
        return marketOrderList;
    }
}
