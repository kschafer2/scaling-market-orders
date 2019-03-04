package calculations;

import data.SequenceTradeData;
import data.TradeType;

public class GeometricSequenceTradeCalculations extends AbstractSequenceTradeCalculations
        implements FirstMarketOrderCalculations, NextMarketOrderCalculations {

    public GeometricSequenceTradeCalculations(SequenceTradeData data) {
        super(data);
    }

    @Override
    public double calculateFirstMarketOrderVolume() {
        return (data.getTradeVolume() * (1 - data.getDifferenceBetween())) /
                (1 - Math.pow(data.getDifferenceBetween(), data.getNumberOfMarketOrders()));
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
        return previousVolume * data.getDifferenceBetween();
    }

    @Override
    public double calculateNextMarketOrderPrice(double previousPrice) {

        if(data.getTradeType() == TradeType.BUY)
            return previousPrice - calculateMarketOrderPriceInterval();

        else
            return previousPrice + calculateMarketOrderPriceInterval();
    }
}