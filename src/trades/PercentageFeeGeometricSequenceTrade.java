package trades;

import calculations.sequence.AbstractSequenceTradeCalculations;
import calculations.sequence.GeometricSequenceTradeCalculations;
import data.SeqTradeData;
import fees.Fee;
import orders.FeeMarketOrder;
import orders.GenericMarketOrder;

import java.util.ArrayList;

public class PercentageFeeGeometricSequenceTrade extends AbstractTrade<AbstractSequenceTradeCalculations>
        implements Buildable, FirstOrderDependent {

    private Fee fee;

    public PercentageFeeGeometricSequenceTrade(SeqTradeData data, Fee fee) {
        super.calculations = new GeometricSequenceTradeCalculations(data);
        super.marketOrderList = new ArrayList<>();
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


