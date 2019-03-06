package calculations;

public interface TradeCalculations<T> {

    T getData();

    void setData(T data);

    double calculateMarketOrderPriceRange();

    double calculateMarketOrderPriceInterval();
}
