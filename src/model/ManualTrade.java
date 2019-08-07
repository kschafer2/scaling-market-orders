package model;

import java.math.BigDecimal;
import java.util.Comparator;

import static model.TradeType.BUY;

public class ManualTrade extends Trade {

    public ManualTrade(TradeType type) {
        this.type = type;
    }

    @Override
    protected void build() {
        Comparator<MarketOrder> comparator
                = Comparator.comparing(MarketOrder::getAssetPrice);

        if(type == BUY) {
            marketOrders.sort(comparator.reversed());
        }

        else {
            marketOrders.sort(comparator);
        }
    }

    public ManualTrade addFee(Fee fee) {
        this.fee = fee;

        return this;
    }

    public ManualTrade addOrder(MarketOrder marketOrder) {
        marketOrders.add(marketOrder);

        return update();
    }

    public ManualTrade deleteOrder(MarketOrder marketOrder) {
        marketOrders.remove(marketOrder);

        return update();
    }

    public ManualTrade deleteOrderById(Long id) {
        marketOrders.stream()
                    .filter(order -> order.getId().equals(id))
                    .findFirst()
                    .ifPresent(marketOrders::remove);

        return update();
    }

    public ManualTrade deleteOrderByIndex(int index) {
        if(index < 0 || index > marketOrders.size()) {
            return this;
        }
        marketOrders.remove(index);

        return update();
    }

    private ManualTrade update() {
        numberOfOrders = marketOrders.size();

        totalVolume = BigDecimal.ZERO;
        for(MarketOrder order : marketOrders) {
            totalVolume = totalVolume.add(order.getOrderVolume());
        }

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
