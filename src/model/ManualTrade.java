package model;

import java.util.Comparator;

import static model.TradeType.BUY;

public class ManualTrade extends Trade {

    public ManualTrade(TradeType type) {
        super(type);
    }

    @Override
    protected void build() {
        Comparator<MarketOrder> comparator
                = Comparator.comparingDouble(MarketOrder::getAssetPrice);

        if(type == BUY) {
            marketOrders.sort(comparator.reversed());
        } else {
            marketOrders.sort(comparator);
        }
    }

    public ManualTrade addOrder(MarketOrder marketOrder) {
        marketOrders.add(marketOrder);

        tradeVolume+= marketOrder.getTradeVolume();
        ++totalOrders;

        return this;
    }

    public ManualTrade percentageFee(double percentageFee) {
        this.percentageFee = percentageFee;

        return this;
    }



}
