package lists;

import buildable.Buildable;
import calculations.GeometricScalingTradeCalculations;
import data.AbstractTradeData;
import orders.AbstractMarketOrder;

import java.util.List;

public abstract class AbstractMarketOrderList implements Buildable, MutableMarketOrders, UniqueFirstMarketOrder {

    List<AbstractMarketOrder> marketOrderList;
    AbstractTradeData data;
    GeometricScalingTradeCalculations calculations;

    public AbstractMarketOrderList(AbstractTradeData data) {
        this.data = data;
    }
}
