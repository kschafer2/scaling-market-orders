package trades;

import calculations.SeqTradeCalculations;
import fees.Fee;
import orders.FeeMarketOrder;
import orders.GenericMarketOrder;
import orders.MarketOrder;

import java.util.ArrayList;

public class PercentageFeeGeometricSequenceTrade extends AbstractGeometricSequenceTrade {

    private Fee fee;

    public PercentageFeeGeometricSequenceTrade(ArrayList<MarketOrder> marketOrderList,
                                               SeqTradeCalculations calculations, Fee fee) {

        super(marketOrderList, calculations);
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


