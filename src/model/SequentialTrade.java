package model;

import static model.TradeType.BUY;

public abstract class SequentialTrade extends Trade {

    private double minOrderPrice;
    private double maxOrderPrice;
    double differenceBetweenOrders;

    SequentialTrade(TradeType type, int numberOfOrders, double totalVolume, double minOrderPrice,
                              double maxOrderPrice, double differenceBetweenOrders) {
        this.type = type;
        this.numberOfOrders = numberOfOrders;
        this.totalVolume = totalVolume;
        this.minOrderPrice = minOrderPrice;
        this.maxOrderPrice = maxOrderPrice;
        this.differenceBetweenOrders = differenceBetweenOrders;
    }

    SequentialTrade(TradeType type, int numberOfOrders, double totalVolume, double minOrderPrice,
                              double maxOrderPrice, double differenceBetweenOrders, double percentageFee) {

        this(type, numberOfOrders, totalVolume, minOrderPrice, maxOrderPrice, differenceBetweenOrders);
        this.percentageFee = percentageFee;
    }

    abstract double getFirstOrderVolume();

    abstract double getOrderVolume(MarketOrder previousMarketOrder);

    @Override
    protected void build() {
        for(int i = 0; i < numberOfOrders; ++i) {
            addOrderAtIndex(i);
        }
    }

    private void addOrderAtIndex(int index) {
        double orderPrice;

        if(index == 0 && marketOrders.isEmpty()) {
            if(type == BUY) {
                orderPrice = maxOrderPrice;
            }

            else {
                orderPrice = minOrderPrice;
            }

            marketOrders.add(new MarketOrder(
                            orderPrice,
                            getFirstOrderVolume()));
        }

        else if(index > 0) {
            double priceInterval = (maxOrderPrice - minOrderPrice)/(numberOfOrders-1);
            MarketOrder previousMarketOrder = marketOrders.get(index-1);

            if(type == BUY) {
                orderPrice = previousMarketOrder.getAssetPrice() - priceInterval;
            }

            else {
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

        stringBuilder.append("minOrderPrice=")
                .append(minOrderPrice)
                .append(", maxOrderPrice=")
                .append(maxOrderPrice)
                .append(", differenceBetweenOrders=")
                .append(differenceBetweenOrders)
                .append(", type=")
                .append(type)
                .append(", numberOfOrders=")
                .append(numberOfOrders)
                .append(", totalVolume=")
                .append(totalVolume)
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
