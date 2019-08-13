package model;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_DOWN;
import static model.TradeType.BUY;

public abstract class SequentialTrade extends Trade {

    private BigDecimal minOrderPrice;
    private BigDecimal maxOrderPrice;
    BigDecimal differenceBetweenOrders;

    SequentialTrade(TradeType type, int numberOfOrders, double totalVolume, double minOrderPrice,
                    double maxOrderPrice, double differenceBetweenOrders) {
        this.type = type;
        this.numberOfOrders = numberOfOrders;
        this.totalVolume = BigDecimal.valueOf(totalVolume);
        this.minOrderPrice = BigDecimal.valueOf(minOrderPrice);
        this.maxOrderPrice = BigDecimal.valueOf(maxOrderPrice);
        this.differenceBetweenOrders = BigDecimal.valueOf(differenceBetweenOrders);
    }

    SequentialTrade(TradeType type, int numberOfOrders, double totalVolume, double minOrderPrice,
                    double maxOrderPrice, double differenceBetweenOrders, Fee fee) {

        this(type, numberOfOrders, totalVolume, minOrderPrice, maxOrderPrice, differenceBetweenOrders);
        this.fee = fee;
    }

    abstract BigDecimal getOrderVolumeAtIndex(int index);

    @Override
    public Trade build() {
        if (marketOrders.isEmpty()) {
            for (int i = 0; i < numberOfOrders; ++i) {
                addOrderAtIndex(i);
            }
            applyFee();
        }

        return this;
    }

    private void addOrderAtIndex(int index) {
        //todo handle exception better
        if (index < 0 || index > numberOfOrders) {
            throw new ArrayIndexOutOfBoundsException();
        }

        BigDecimal orderPrice;

        if (index == 0) {
            if (type == BUY) {
                orderPrice = maxOrderPrice.setScale(scale(), HALF_DOWN);
            }
            else {
                orderPrice = minOrderPrice.setScale(scale(), HALF_DOWN);
            }
        }
        else {
//          priceInterval = (maxOrderPrice - minOrderPrice)/(numberOfOrders-1);
            BigDecimal priceInterval = maxOrderPrice.subtract(minOrderPrice)
                                        .setScale(scale(), HALF_DOWN)
                        .divide(BigDecimal.valueOf(numberOfOrders - 1), HALF_DOWN)
                        .setScale(scale(), HALF_DOWN);

            BigDecimal previousMarketOrderPrice = marketOrders.get(index - 1).getAssetPrice();

            if (type == BUY) {
                orderPrice = previousMarketOrderPrice.subtract(priceInterval);
            }
            else {
                orderPrice = previousMarketOrderPrice.add(priceInterval);
            }
        }
        marketOrders.add(index, new MarketOrder(orderPrice, getOrderVolumeAtIndex(index)));
    }

    private int scale() {
        return Math.max(minOrderPrice.scale(), maxOrderPrice.scale()) + 2;
    }

    @Override
    public String toString() {

        return super.toString() +
                ", minOrderPrice=" + minOrderPrice +
                ", maxOrderPrice=" + maxOrderPrice +
                ", differenceBetweenOrders=" + differenceBetweenOrders +
                "}" +
                marketOrdersToString();
    }
}
