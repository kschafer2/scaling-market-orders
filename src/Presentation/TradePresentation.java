package Presentation;

import orders.AbstractMarketOrder;

import java.util.List;

public class TradePresentation implements Printable, WeightedAverage {

    List marketOrderList;

    public TradePresentation(List<AbstractMarketOrder> marketOrderList) {

        this.marketOrderList = marketOrderList;
    }

    @Override
    public void print() {
        for(int i =0; i < marketOrderList.size(); i++) {
            AbstractMarketOrder marketOrder = (AbstractMarketOrder) marketOrderList.get(i);

            System.out.println(marketOrder.getAssetPrice() + "\t" + marketOrder.getTradeVolume());
        }

        System.out.println();
        System.out.println(calculateWeightedAverage());
    }

    @Override
    public double calculateWeightedAverage() {
        double sumProduct = 0;
        double sum = 0;


        for(int i =0; i < marketOrderList.size(); i++) {
            AbstractMarketOrder marketOrder = (AbstractMarketOrder) marketOrderList.get(i);

            sumProduct += (marketOrder.getAssetPrice() * marketOrder.getTradeVolume());
            sum += marketOrder.getTradeVolume();
        }

        return sumProduct/sum;
    }
}
