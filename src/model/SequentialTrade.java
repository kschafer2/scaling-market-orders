package model;

import static model.TradeType.BUY;

public abstract class SequentialTrade extends Trade {

    protected double minPrice;
    protected double maxPrice;
    protected double difference;

    protected SequentialTrade(TradeType type, int totalOrders, double tradeVolume,
                           double minPrice, double maxPrice, double difference) {

        super(type, totalOrders, tradeVolume);
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.difference = difference;
    }

    protected SequentialTrade(TradeType type, int totalOrders, double tradeVolume,
                           double minPrice, double maxPrice, double difference,
                           double percentageFee) {

        super(type, totalOrders, tradeVolume, percentageFee);
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.difference = difference;
    }

    abstract double getFirstOrderVolume();

    abstract double getOrderVolume(MarketOrder previousMarketOrder);

    @Override
    protected void build() {
        for(int i = 0; i < totalOrders; ++i) {
            addOrderAtIndex(i);
        }
    }

    private void addOrderAtIndex(int index) {
        double orderPrice;

        if(index == 0 && marketOrders.isEmpty()) {
            double firstOrderPrice;

            if(type == BUY) {
                orderPrice = maxPrice;
            } else {
                orderPrice = minPrice;
            }

            marketOrders.add(new MarketOrder(
                            orderPrice,
                            getFirstOrderVolume()));
        }

        else if(index > 0) {
            double priceInterval = (maxPrice-minPrice)/(totalOrders-1);
            MarketOrder previousMarketOrder = marketOrders.get(index-1);

            if(type == BUY) {
                orderPrice = previousMarketOrder.getAssetPrice() - priceInterval;
            } else {
                orderPrice = previousMarketOrder.getAssetPrice() + priceInterval;
            }

            marketOrders.add(new MarketOrder(
                            orderPrice,
                            getOrderVolume(previousMarketOrder)));
        }
    }

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
