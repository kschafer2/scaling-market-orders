package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class Trade extends BaseEntity {

    TradeType type;
    int numberOfOrders;
    BigDecimal totalVolume;
    Fee fee;
    List<MarketOrder> marketOrders = new ArrayList<>();

    abstract void build();

    //todo make abstract or add fee application to build methods
    public Trade activate() {
        build();

        if (fee != null && !fee.getIsApplied()) {
            marketOrders.forEach(order ->
                    order.setOrderVolume(fee.applyTo(order.getOrderVolume())));

            fee.setIsApplied(true);
//            totalVolume = fee.applyTo(totalVolume);
        }
        updateTrade();

        return this;
    }

    protected void updateTrade() {
        numberOfOrders = marketOrders.size();

        totalVolume = BigDecimal.ZERO;
        for(MarketOrder order : marketOrders) {
            totalVolume = totalVolume.add(order.getOrderVolume());
        }
    }

    String marketOrdersToString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(System.lineSeparator());

        marketOrders.forEach(order -> stringBuilder
                .append(order)
                .append(System.lineSeparator()));

        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("id=").append(id)
                .append(", type=").append(type)
                .append(", numberOfOrders=").append(numberOfOrders)
                .append(", totalVolume=").append(totalVolume);

        if (fee != null) {
            stringBuilder.append(", fee=").append(fee.getValue());
        }
        return stringBuilder.toString();
    }
}
