package calculations;

import data.GeometricScalingTradeData;
import data.TradeType;

public class GeometricScalingTradeCalculations extends AbstractGeometricScalingTradeCalculations
        implements FirstMarketOrderCalculations, NextMarketOrderCalculations {

    public GeometricScalingTradeCalculations(GeometricScalingTradeData data) {
        super(data);
    }

    @Override
    public double calculateFirstMarketOrderVolume() {
        return (data.getTradeVolume() * (1 - data.getScale())) /
                (1 - Math.pow(data.getScale(), data.getNumberOfMarketOrders()));
    }

    @Override
    public double calculateFirstMarketOrderPrice() {
        if(data.getTradeType() == TradeType.BUY)
            return data.getMaxMarketOrderPrice();

        else
            return data.getMinMarketOrderPrice();
    }

    @Override
    public double calculateNextMarketOrderVolume(double previousVolume) {
        return previousVolume * data.getScale();
    }

    @Override
    public double calculateNextMarketOrderPrice(double previousPrice) {

        if(data.getTradeType() == TradeType.BUY)
            return previousPrice - calculateMarketOrderPriceInterval();

        else
            return previousPrice + calculateMarketOrderPriceInterval();
    }
}
