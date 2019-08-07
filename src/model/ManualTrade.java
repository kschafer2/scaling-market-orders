package model;

import java.util.Comparator;

import static model.TradeType.BUY;

public class ManualTrade extends Trade {

    public ManualTrade(TradeType type) {
        this.type = type;
    }

    @Override
    protected void build() {
        Comparator<MarketOrder> comparator
                = Comparator.comparingDouble(MarketOrder::getAssetPrice);

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

    private void updateTrade() {
        this.numberOfOrders = marketOrders.size();

         this.totalVolume = marketOrders.stream()
                                        .mapToDouble(MarketOrder::getOrderVolume)
                                        .sum();
    }

    @Override
    public String toString() {
        return "ManualTrade{" +
                super.toString() +
                "}" +
                marketOrdersToString();
    }
}
