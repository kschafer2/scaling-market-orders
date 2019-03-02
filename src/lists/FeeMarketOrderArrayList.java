package lists;

import fees.Fee;
import orders.FeeMarketOrder;
import orders.MarketOrder;
import orders.MarketOrderImpl;
import support.TradeCalculations;
import support.ScalingTradeCalculations;
import support.TradeData;

import java.util.ArrayList;

public class FeeMarketOrderArrayList implements MarketOrderList {

    private ArrayList<MarketOrder> marketOrderList;
    private TradeData data;
    private TradeCalculations calculations;
    private Fee fee;

    public FeeMarketOrderArrayList(TradeData data, Fee fee) {
        this.data = data;
        calculations = new ScalingTradeCalculations(data);
        marketOrderList = new ArrayList<>();
        this.fee = fee;

        buildOrderList();
    }

    @Override
    public void setFirstMarketOrder() {
        marketOrderList.add(new FeeMarketOrder(calculations.calculateFirstMarketOrderPrice(),
                calculations.calculateFirstMarketOrderVolume(), fee));

    }

    @Override
    public void setMarketOrder(int i) {
        double price = calculations.calculateNextMarketOrderPrice(marketOrderList.get(i-1).getAssetPrice());
        double volume = calculations.calculateNextMarketOrderVolume(marketOrderList.get(i-1).getTradeVolume());
        marketOrderList.add(new MarketOrderImpl(price, volume));
    }

    @Override
    public void buildOrderList() {

        setFirstMarketOrder();
        for (int i = 1; i < data.getNumberOfMarketOrders(); i++) {
            setMarketOrder(i);

        }
    }
}
