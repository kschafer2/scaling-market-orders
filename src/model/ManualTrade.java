package model;

import java.util.Comparator;

import static model.TradeType.BUY;

public class ManualTrade extends Trade {

    ManualTrade(TradeType type) {
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

    public ManualTrade percentageFee(double percentageFee) {
        this.percentageFee = percentageFee;

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
    public void updateTrade() {
        this.numberOfOrders = marketOrders.size();

         this.totalVolume = marketOrders.stream()
                                        .mapToDouble(MarketOrder::getOrderVolume)
                                        .sum();
    }
}
