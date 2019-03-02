package lists;

import fees.Fee;
import orders.FeeMarketOrder;
import orders.MarketOrder;
import orders.MarketOrderImpl;
import support.TradeCalculations;
import support.TradeCalculationsImpl;
import support.TradeData;

import java.util.ArrayList;

public class MarketOrderArrayList implements MarketOrderListInt{

    private ArrayList<MarketOrder> marketOrderList;
    private TradeData data;
    private TradeCalculations calculations;
    private Fee fee;

    public MarketOrderArrayList(TradeData data, Fee fee) {
        this.data = data;
        calculations = new TradeCalculationsImpl(data);
        marketOrderList = new ArrayList<MarketOrder>();
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
