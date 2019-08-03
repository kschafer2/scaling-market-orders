package trades;

import calculations.sequence.AbstractSequenceTradeCalculations;
import calculations.sequence.GeometricSequenceTradeCalculations;
import data.SeqTradeData;
import fees.Fee;
import orders.FeeMarketOrder;
import orders.GenericMarketOrder;
import orders.MarketOrder;

import java.util.ArrayList;

public class PercentageFeeGeometricSequenceTrade extends Trade<AbstractSequenceTradeCalculations>
        implements Buildable, FirstOrderDependent {

    private Fee fee;

    public PercentageFeeGeometricSequenceTrade(SeqTradeData data, Fee fee) {
        this.calculations = new GeometricSequenceTradeCalculations(data);
        this.marketOrders = new ArrayList<>();
        this.fee = fee;
        build();
    }

    @Override
    public void build() {
        addFirstMarketOrder();

        for(int i = 1; i < calculations.getData().getNumberOfMarketOrders(); i++) {
            addMarketOrder(i);
        }
    }

    @Override
    public void addMarketOrder(int index) {
        if(index <= 0) {
            return;
        }

        marketOrders.add(new GenericMarketOrder(
                            calculations.calculateNextMarketOrderPrice(
                                    getPreviousMarketOrder(index).getAssetPrice()),
                            calculations.calculateNextMarketOrderVolume(
                                    getPreviousMarketOrder(index).getTradeVolume())));
    }

    @Override
    public void addFirstMarketOrder() {
        marketOrders.add(new FeeMarketOrder(
                            calculations.calculateFirstMarketOrderPrice(),
                            calculations.calculateFirstMarketOrderVolume(),
                            fee));
    }

    private MarketOrder getPreviousMarketOrder(int index) {
        return marketOrders.get(index - 1);
    }
}


