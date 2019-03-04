package trades;

import data.SequenceTradeData;
import fees.PercentageFee;
import orders.FeeMarketOrder;
import orders.GenericMarketOrder;

public class PercentageFeeGeometricSequenceTrade extends AbstractGeometricSequenceTrade {

    private PercentageFee fee;

    public PercentageFeeGeometricSequenceTrade(SequenceTradeData data, PercentageFee fee) {
        super(data);
        this.fee = fee;
        build();
    }

    @Override
    public void build() {
        addFirstMarketOrder();
        for (int i = 1; i < calculations.getData().getNumberOfMarketOrders(); i++) {
            addMarketOrder(i);
        }
    }

    @Override
    public void addMarketOrder(int index) {
        double price = calculations.calculateNextMarketOrderPrice(marketOrderList.get(index - 1).getAssetPrice());
        double volume = calculations.calculateNextMarketOrderVolume(marketOrderList.get(index - 1).getTradeVolume());
        marketOrderList.add(new GenericMarketOrder(price, volume));
    }

    @Override
    public void addFirstMarketOrder() {
        marketOrderList.add(new FeeMarketOrder(calculations.calculateFirstMarketOrderPrice(),
                calculations.calculateFirstMarketOrderVolume(), fee));
    }
}


