package calculations;

public interface FirstMarketOrderDependentCalculations extends TradeCalculations {

    double calculateFirstMarketOrderVolume();

    double calculateFirstMarketOrderPrice();

    double calculateNextMarketOrderVolume(double previousVolume);

    double calculateNextMarketOrderPrice(double previousPrice);
}
