package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class Trade extends BaseEntity {

    TradeType type;
    int numberOfOrders;
    BigDecimal totalVolume;
    Fee fee;
    List<MarketOrder> marketOrders;

    public abstract Trade build();

    {
        marketOrders = new ArrayList<>();
    }

    protected void applyFee() {
        if (fee != null && !fee.isApplied()) {
            marketOrders.forEach(order ->
                    order.setOrderVolume(fee.applyTo(order.getOrderVolume())));

            fee.isApplied(true);
        }
        updateTrade();
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
