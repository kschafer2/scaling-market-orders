package trades;

import data.TradeType;
import orders.GenericMarketOrder;
import orders.MarketOrder;

public abstract class SequentialTrade extends Trade2 {

    protected double minPrice;
    protected double maxPrice;
    protected double difference;

    public SequentialTrade(TradeType type, int totalOrders, double tradeVolume,
                           double minPrice, double maxPrice, double difference) {

        super(type, totalOrders, tradeVolume);
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.difference = difference;
    }

    public SequentialTrade(TradeType type, int totalOrders, double tradeVolume,
                           double minPrice, double maxPrice, double difference, double fee) {

        super(type, totalOrders, tradeVolume, fee);
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.difference = difference;
    }

    @Override
    protected void build() {
        addFirstOrder();

        for(int i = 1; i < totalOrders; i++) {
            addMarketOrder(i);
        }
    }

    private void addMarketOrder(int index) {
        if(index <= 0) {
            return;
        }

        marketOrders.add(new GenericMarketOrder(
                getNextOrderPrice(getOrderPrecedingIndex(index).getAssetPrice()),
                getNextOrderVolume(getOrderPrecedingIndex(index).getTradeVolume())));
    }

    private void addFirstOrder() {
        marketOrders.add(new GenericMarketOrder(
                getFirstOrderPrice(),
                getFirstOrderVolume()));
    }

    private MarketOrder getOrderPrecedingIndex(int index) {
        return marketOrders.get(index - 1);
    }

    abstract double getFirstOrderVolume();

    private double getFirstOrderPrice() {
        if(type == TradeType.BUY)
            return maxPrice;

        else
            return minPrice;
    }

    abstract double getNextOrderVolume(double previousVolume);

    //common
    private double getNextOrderPrice(double previousPrice) {

        if(type == TradeType.BUY)
            return previousPrice - getOrderPriceInterval();

        else
            return previousPrice + getOrderPriceInterval();
    }

    //common
    private double getOrderPriceInterval() {
        return (maxPrice-minPrice)/(totalOrders - 1);
    }

    //common
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("GeometricTrade{" + "minPrice=")
                .append(minPrice)
                .append(", maxPrice=")
                .append(maxPrice)
                .append(", difference=")
                .append(difference)
                .append(", type=")
                .append(type)
                .append(", totalOrders=")
                .append(totalOrders)
                .append(", tradeVolume=")
                .append(tradeVolume)
                .append(", percentageFee=")
                .append(percentageFee)
                .append('}')
                .append(System.lineSeparator());

        for(MarketOrder order : marketOrders) {
            stringBuilder.append(order).append(System.lineSeparator());
        }

        return stringBuilder.toString();
    }
}
