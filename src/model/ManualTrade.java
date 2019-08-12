package model;

import java.util.Comparator;

import static model.TradeType.BUY;

public class ManualTrade extends Trade {

    public ManualTrade(TradeType type) {
        this.type = type;
    }

    @Override
    public ManualTrade build() {
        Comparator<MarketOrder> comparator
                = Comparator.comparing(MarketOrder::getAssetPrice);

        if(type == BUY) {
            marketOrders.sort(comparator.reversed());
        }

        else {
            marketOrders.sort(comparator);
        }

        applyFee();

        return this;
    }

    public ManualTrade addFee(Fee fee) {
        this.fee = fee;

        return this;
    }

    public ManualTrade addOrder(MarketOrder marketOrder) {
        marketOrders.add(marketOrder);
        updateTrade();
        return this;
    }

    public ManualTrade deleteOrder(MarketOrder marketOrder) {
        marketOrders.remove(marketOrder);
        updateTrade();
        return this;
    }

    public ManualTrade deleteOrderById(Long id) {
        marketOrders.stream()
                    .filter(order -> order.getId().equals(id))
                    .findFirst()
                    .ifPresent(marketOrders::remove);
        updateTrade();
        return this;
    }

    public ManualTrade deleteOrderByIndex(int index) {
        if(index < 0 || index > marketOrders.size()) {
            return this;
        }
        marketOrders.remove(index);
        updateTrade();
        return this;
    }

    @Override
    public String toString() {
        return "ManualTrade{" +
                super.toString() +
                "}" +
                marketOrdersToString();
    }
}
