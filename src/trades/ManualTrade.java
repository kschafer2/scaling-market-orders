package trades;

import data.TradeType;
import orders.MarketOrder;

import java.util.Comparator;

public class ManualTrade extends Trade {
    //todo implement this

    public ManualTrade(TradeType type) {
        super(type);
    }

    @Override
    protected void build() {
        Comparator<MarketOrder> comparator = Comparator.comparingDouble(MarketOrder::getAssetPrice);

        if(type == TradeType.BUY) {
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
