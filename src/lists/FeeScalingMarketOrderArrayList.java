package lists;

import calculations.ScalingTradeCalculations;
import calculations.AbstractTradeCalculations;
import data.ScalingTradeData;
import data.AbstractTradeData;
import fees.AbstractFee;
import orders.FeeMarketOrder;
import orders.MarketOrder;
import orders.MarketOrderImpl;

import java.util.ArrayList;
import java.util.List;

public class FeeScalingMarketOrderArrayList extends AbstractMarketOrderList {

    //private List<MarketOrder> marketOrderList;
    //private AbstractTradeData data;
    //private AbstractTradeCalculations calculations;
    private AbstractFee fee;

    /*public FeeScalingMarketOrderArrayList(ScalingTradeData data, AbstractFee fee) {
        this.data = data;
        calculations = new ScalingTradeCalculations(data);
        marketOrderList = new ArrayList<>();
        this.fee = fee;

        buildOrderList();
    }*/

    public FeeScalingMarketOrderArrayList(ScalingTradeData data, AbstractFee fee) {
        super(data);
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
