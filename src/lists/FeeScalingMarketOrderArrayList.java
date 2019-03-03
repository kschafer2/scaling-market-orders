package lists;

import calculations.GeometricScalingTradeCalculations;
import data.GeometricScalingTradeData;
import fees.AbstractFee;
import orders.FeeMarketOrder;
import orders.MarketOrderImpl;

import java.util.ArrayList;

public class FeeScalingMarketOrderArrayList extends AbstractMarketOrderList {

    //private List<AbstractMarketOrder> marketOrderList;
    //private AbstractTradeData data;
    //private AbstractGeometricScalingTradeCalculations calculations;
    private AbstractFee fee;

    /*public FeeScalingMarketOrderArrayList(GeometricScalingTradeData data, AbstractFee fee) {
        this.data = data;
        calculations = new GeometricScalingTradeCalculations(data);
        marketOrderList = new ArrayList<>();
        this.fee = fee;

        buildOrderList();
    }*/

    public FeeScalingMarketOrderArrayList(GeometricScalingTradeData data, AbstractFee fee) {
        super(data);
        calculations = new GeometricScalingTradeCalculations(data);
        marketOrderList = new ArrayList<>(20);
        this.fee = fee;
        build();
    }

    @Override
    public void addFirstMarketOrder() {
        marketOrderList.add(new FeeMarketOrder(calculations.calculateFirstMarketOrderPrice(),
                calculations.calculateFirstMarketOrderVolume(), fee));

    }

    @Override
    public void addMarketOrder(int index) {
        double price = calculations.calculateNextMarketOrderPrice(marketOrderList.get(index - 1).getAssetPrice());
        double volume = calculations.calculateNextMarketOrderVolume(marketOrderList.get(index - 1).getTradeVolume());
        marketOrderList.add(new MarketOrderImpl(price, volume));
    }

    @Override
    public void build() {

        addFirstMarketOrder();
        for (int i = 1; i < data.getNumberOfMarketOrders(); i++) {
            addMarketOrder(i);

        }
    }
}
