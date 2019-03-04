package calculations;

public interface NextMarketOrderCalculations {

    double calculateNextMarketOrderVolume(double previousVolume);

    double calculateNextMarketOrderPrice(double previousPrice);

}
