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
        setCalculations(new GeometricSequenceTradeCalculations(data));
        setMarketOrderList(new ArrayList<>());
        this.fee = fee;
        build();
    }

    @Override
    public void build() {
        addFirstMarketOrder();
        for (int i = 1; i < getCalculations().getData().getNumberOfMarketOrders(); i++) {
            addMarketOrder(i);
        }
    }

    @Override
    public void addMarketOrder(int index) {
        double price = getCalculations().calculateNextMarketOrderPrice(getMarketOrderList().get(index - 1).getAssetPrice());
        double volume = getCalculations().calculateNextMarketOrderVolume(getMarketOrderList().get(index - 1).getTradeVolume());
        getMarketOrderList().add(new GenericMarketOrder(price, volume));
    }

    @Override
    public void addFirstMarketOrder() {
        getMarketOrderList().add(new FeeMarketOrder(getCalculations().calculateFirstMarketOrderPrice(),
                getCalculations().calculateFirstMarketOrderVolume(), fee));
    }
}


