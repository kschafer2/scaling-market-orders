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
        this.totalVolume = new BigDecimal(String.valueOf(totalVolume));
        this.minOrderPrice = new BigDecimal(String.valueOf(minOrderPrice));
        this.maxOrderPrice = new BigDecimal(String.valueOf(maxOrderPrice));
        this.differenceBetweenOrders = new BigDecimal(String.valueOf(differenceBetweenOrders));
    }

    SequentialTrade(TradeType type, int numberOfOrders, double totalVolume, double minOrderPrice,
                              double maxOrderPrice, double differenceBetweenOrders, Fee fee) {

        this(type, numberOfOrders, totalVolume, minOrderPrice, maxOrderPrice, differenceBetweenOrders);
        this.fee = fee;
    }

    abstract BigDecimal getFirstOrderVolume();

    abstract BigDecimal getOrderVolume(MarketOrder previousMarketOrder);

    @Override
    protected void build() {
        for(int i = 0; i < numberOfOrders; ++i) {
            addOrderAtIndex(i);
        }
    }

    private void addOrderAtIndex(int index) {
        BigDecimal orderPrice;

        if(index == 0 && marketOrders.isEmpty()) {
            if(type == BUY) {
                orderPrice = maxOrderPrice.setScale(scale(), HALF_DOWN);
            }

            else {
                orderPrice = minOrderPrice.setScale(scale(), HALF_DOWN);
            }

            marketOrders.add(new MarketOrder(
                            orderPrice,
                            getFirstOrderVolume()));
        }

        else if(index > 0) {
//            BigDecimal priceInterval = (maxOrderPrice - minOrderPrice)/(numberOfOrders-1);

            BigDecimal dividend = maxOrderPrice.subtract(minOrderPrice)
                                        .setScale(scale(), HALF_DOWN);

            BigDecimal divisor = BigDecimal.valueOf(numberOfOrders-1);

            BigDecimal priceInterval = dividend.divide(divisor, HALF_DOWN)
                                        .setScale(scale(), HALF_DOWN);

            MarketOrder previousMarketOrder = marketOrders.get(index-1);

            if(type == BUY) {
                orderPrice = previousMarketOrder.getAssetPrice().subtract(priceInterval);
            }

            else {
                orderPrice = previousMarketOrder.getAssetPrice().add(priceInterval);
            }

            marketOrders.add(new MarketOrder(
                            orderPrice,
                            getOrderVolume(previousMarketOrder)));
        }
    }

    private int scale() {
        return Math.max(minOrderPrice.scale(), maxOrderPrice.scale())+2;
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
