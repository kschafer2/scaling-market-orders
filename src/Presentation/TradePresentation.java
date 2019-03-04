package Presentation;

import orders.GenericMarketOrder;

import java.util.List;

public class TradePresentation implements Printable, WeightedAverage {

    List marketOrderList;

    public TradePresentation(List<GenericMarketOrder> marketOrderList) {

        this.marketOrderList = marketOrderList;
    }

    @Override
    public void print() {
        for (Object order : marketOrderList) {
            GenericMarketOrder marketOrder = (GenericMarketOrder) order;

            System.out.println(marketOrder.getAssetPrice() + "\t" + marketOrder.getTradeVolume());
        }

        System.out.println();
        System.out.println(calculateWeightedAverage());
    }

    @Override
    public double calculateWeightedAverage() {
        double sumProduct = 0;
        double sum = 0;


        for (Object order : marketOrderList) {
            GenericMarketOrder marketOrder = (GenericMarketOrder) order;

            sumProduct += (marketOrder.getAssetPrice() * marketOrder.getTradeVolume());
            sum += marketOrder.getTradeVolume();
        }

        return sumProduct/sum;
    }
}
