package calculations;

public interface FirstMarketOrderDependentCalculations {

    double calculateFirstMarketOrderVolume();

    double calculateFirstMarketOrderPrice();

    double calculateNextMarketOrderVolume(double previousVolume);

    double calculateNextMarketOrderPrice(double previousPrice);
}
