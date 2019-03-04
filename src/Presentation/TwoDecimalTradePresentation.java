package Presentation;

import orders.AbstractMarketOrder;

import java.text.DecimalFormat;
import java.util.List;

public class TwoDecimalTradePresentation extends TradePresentation {

    public TwoDecimalTradePresentation(List<AbstractMarketOrder> marketOrderList) {
        super(marketOrderList);

    }

    @Override
    public void print() {
        DecimalFormat numberFormat = new DecimalFormat("#.00");

        for(int i =0; i < marketOrderList.size(); i++) {
            AbstractMarketOrder marketOrder = (AbstractMarketOrder) marketOrderList.get(i);

            System.out.println(numberFormat.format(marketOrder.getAssetPrice()) + "\t\t" +
                    numberFormat.format(marketOrder.getTradeVolume()));
        }

        System.out.println();
        System.out.println(numberFormat.format(calculateWeightedAverage()));
    }

}
