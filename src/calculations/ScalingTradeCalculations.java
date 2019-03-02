package calculations;

import data.TradeData;
import data.TradeType;

public class ScalingTradeCalculations extends TradeCalculations {

    public ScalingTradeCalculations(TradeData data) {
        super(data);
    }

    @Override
    public double calculateFirstMarketOrderVolume() {
        return (data.getTradeVolume()*(1-data.getScalingRatio()))/
                (1-Math.pow(data.getScalingRatio(), data.getNumberOfMarketOrders()));
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
        return previousVolume * data.getScalingRatio();
    }

    @Override
    public double calculateNextMarketOrderPrice(double previousPrice) {
        return previousPrice + calculateMarketOrderPriceInterval();
    }
}
