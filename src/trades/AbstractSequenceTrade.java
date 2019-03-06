package trades;

import calculations.AbstractSequenceTradeCalculations;
import orders.MarketOrder;

import java.util.List;

public abstract class AbstractSequenceTrade extends AbstractTrade<AbstractSequenceTradeCalculations>
        implements Buildable, FirstOrderDependent {

    List<MarketOrder> marketOrderList;
    AbstractSequenceTradeCalculations calculations;

    public List<MarketOrder> getMarketOrderList() {
        return marketOrderList;
    }
}
