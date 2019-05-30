package calculations.sequence;

import data.SeqTradeData;
import data.TradeType;

public class GeometricSequenceTradeCalculations extends AbstractSequenceTradeCalculations {

    public GeometricSequenceTradeCalculations(SeqTradeData data) {
        super(data);
    }

    @Override
    public double calculateFirstMarketOrderVolume() {

        //split tradeVolume evenly to each marketOrder
        if(getData().getFunctionCoefficient() == 1) {
            return getData().getTradeVolume()/getData().getNumberOfMarketOrders();
        }

        //derived from finite geometric series formula (Sn=a1(1-rn)1-r, r!=1)
        return (getData().getTradeVolume() * (1 - getData().getFunctionCoefficient())) /
                (1 - Math.pow(getData().getFunctionCoefficient(), getData().getNumberOfMarketOrders()));
    }

    @Override
    public double calculateFirstMarketOrderPrice() {
        if(getData().getTradeType() == TradeType.BUY)
            return getData().getMaxMarketOrderPrice();

        else
            return getData().getMinMarketOrderPrice();
    }

    @Override
    public double calculateNextMarketOrderVolume(double previousVolume) {
        return previousVolume * getData().getFunctionCoefficient();
    }

    @Override
    public double calculateNextMarketOrderPrice(double previousPrice) {

        if(getData().getTradeType() == TradeType.BUY)
            return previousPrice - calculateMarketOrderPriceInterval();

        else
            return previousPrice + calculateMarketOrderPriceInterval();
    }
}
