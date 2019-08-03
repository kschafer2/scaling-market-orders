package trades;

import orders.MarketOrder;

import java.util.List;

public abstract class Trade<TradeCalculations> {

    protected List<MarketOrder> marketOrders;
    protected TradeCalculations calculations;
}
