package trades;

import calculations.GeometricSequenceTradeCalculations;
import data.SequenceTradeData;
import orders.GenericMarketOrder;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGeometricSequenceTrade implements Buildable, UniqueFirstMarketOrder, MutableMarketOrders {

    List<GenericMarketOrder> marketOrderList;
    GeometricSequenceTradeCalculations calculations;

    public AbstractGeometricSequenceTrade(SequenceTradeData data) {
        calculations = new GeometricSequenceTradeCalculations(data);
        marketOrderList = new ArrayList<>();
    }

    public List<GenericMarketOrder> getMarketOrderList() {
        return marketOrderList;
    }
}
