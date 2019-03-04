package Presentation;

import orders.GenericMarketOrder;

import java.text.DecimalFormat;
import java.util.List;

public class TwoDecimalTradePresentation extends TradePresentation {

    public TwoDecimalTradePresentation(List<GenericMarketOrder> marketOrderList) {
        super(marketOrderList);

    }

    @Override
    public void print() {
        DecimalFormat numberFormat = new DecimalFormat("#.00");

        for (Object order : marketOrderList) {
            GenericMarketOrder marketOrder = (GenericMarketOrder) order;

            System.out.println(numberFormat.format(marketOrder.getAssetPrice()) + "\t\t" +
                    numberFormat.format(marketOrder.getTradeVolume()));
        }

        System.out.println();
        System.out.println(numberFormat.format(calculateWeightedAverage()));
    }

}
