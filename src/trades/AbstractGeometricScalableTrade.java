package trades;

import buildable.Buildable;
import calculations.GeometricScalingTradeCalculations;
import data.GeometricScalingTradeData;
import lists.MutableMarketOrders;
import lists.UniqueFirstMarketOrder;
import orders.AbstractMarketOrder;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGeometricScalableTrade implements Buildable, UniqueFirstMarketOrder, MutableMarketOrders {

    List<AbstractMarketOrder> marketOrderList;
    GeometricScalingTradeCalculations calculations;

    public AbstractGeometricScalableTrade(GeometricScalingTradeData data) {
        calculations = new GeometricScalingTradeCalculations(data);
        marketOrderList = new ArrayList<>();
    }

    public List<AbstractMarketOrder> getMarketOrderList() {
        return marketOrderList;
    }
}
