package support;

public class TradeCalculationsImpl extends TradeCalculations {

    public TradeCalculationsImpl(TradeData data) {
        super(data);
    }

    @Override
    public double calculateMarketOrderPriceInterval() {
        if(data.getTradeType() == TradeType.BUY)
            return (calculateMarketOrderPriceRange()/(data.getNumberOfMarketOrders() - 1)) / (-1);

        else
            return calculateMarketOrderPriceRange()/(data.getNumberOfMarketOrders() - 1);
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
