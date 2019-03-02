package calculations;

public interface TradeCalculations extends FirstMarketOrderCalculations, NextMarketOrderCalculations {

    double calculateMarketOrderPriceRange();

    double calculateMarketOrderPriceInterval();
}
