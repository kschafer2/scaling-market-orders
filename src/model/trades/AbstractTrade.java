package model.trades;

import model.BaseEntity;
import model.MarketOrder;
import model.TradeType;
import model.fees.AbstractFee;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTrade extends BaseEntity implements Trade {

    protected TradeType type;
    protected int numberOfOrders;
    protected BigDecimal totalVolume;
    protected AbstractFee fee;
    protected List<MarketOrder> marketOrders;

    {
        marketOrders = new ArrayList<>();
    }

    //todo remove fee if a new fee is added
    protected void applyFee() {
        if (fee != null && !fee.isApplied()) {
            marketOrders.forEach(order ->
                    order.setOrderVolume(fee.applyTo(order.getOrderVolume())));

            fee.isApplied(true);
        }
        update();
    }

    @Override
    public void update() {
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

        stringBuilder.append("id=").append(getId())
                .append(", type=").append(type)
                .append(", numberOfOrders=").append(numberOfOrders)
                .append(", totalVolume=").append(totalVolume);

        if (fee != null) {
            stringBuilder.append(", fee=").append(fee.getValue());
        }
        return stringBuilder.toString();
    }
}
