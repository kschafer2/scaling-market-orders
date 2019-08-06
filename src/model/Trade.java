package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Trade extends BaseEntity {

    TradeType type;
    int numberOfOrders;
    double totalVolume;
    double percentageFee;
    List<MarketOrder> marketOrders = new ArrayList<>();

    abstract void build();

    //todo make abstract or add fee application to build methods
    public Trade activate() {
        if(percentageFee > 0) {
            //apply the fee
            totalVolume = totalVolume/(1+(percentageFee/100));
        }
        build();

        return this;
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
        return "id=" + id +
                ", type=" + type +
                ", numberOfOrders=" + numberOfOrders +
                ", totalVolume=" + totalVolume +
                ", percentageFee=" + percentageFee;
    }
}
