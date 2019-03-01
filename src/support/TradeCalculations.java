package support;

public abstract class TradeCalculations {

    TradeData data;

    public double calculateMarketOrderPriceRange() {
        return data.getMaxMarketOrderPrice() - data.getMinMarketOrderPrice();
    }

    public abstract double calculateMarketOrderPriceInterval();

    public abstract double calculateFirstMarketOrderVolume();

    public abstract double calculateNextMarketOrderVolume(double previousVolume);

    public abstract double calculateNextMarketOrderPrice(double previousPrice);
}


