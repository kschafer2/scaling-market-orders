package calculations;

import data.AbstractTradeData;
import data.GeometricScalingTradeData;

public abstract class AbstractGeometricScalingTradeCalculations implements TradeCalculations {

    GeometricScalingTradeData data;

    AbstractGeometricScalingTradeCalculations(GeometricScalingTradeData data) {
        this.data = data;
    }

    public GeometricScalingTradeData getData() {
        return data;
    }

    public void setData(GeometricScalingTradeData data) {
        this.data = data;
    }

    @Override
    public double calculateMarketOrderPriceRange() {
        return data.getMaxMarketOrderPrice() - data.getMinMarketOrderPrice();
    }

    @Override
    public double calculateMarketOrderPriceInterval() {
            return calculateMarketOrderPriceRange()/(data.getNumberOfMarketOrders() - 1);
    }
}


