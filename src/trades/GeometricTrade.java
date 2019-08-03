package trades;

import data.TradeType;

public class GeometricTrade extends SequentialTrade {

    protected GeometricTrade(TradeType type, int totalOrders, double tradeVolume,
                     double minPrice, double maxPrice, double commonRatio) {

        super(type, totalOrders, tradeVolume, minPrice, maxPrice, commonRatio);
    }

    protected GeometricTrade(TradeType type, int totalOrders, double tradeVolume,
                     double minPrice, double maxPrice, double commonRatio, double fee) {

        super(type, totalOrders, tradeVolume, minPrice, maxPrice, commonRatio, fee);
    }

    //common
//    @Override
//    protected void build() {
//        addFirstMarketOrder();
//
//        for(int i = 1; i < totalOrders; i++) {
//            addMarketOrder(i);
//        }
//    }

    //common
//    private void addMarketOrder(int index) {
//        if(index <= 0) {
//            return;
//        }
//
//        marketOrders.add(new GenericMarketOrder(
//                getNextMarketOrderPrice(
//                        getPreviousMarketOrder(index).getAssetPrice()),
//                getNextOrderVolume(
//                        getPreviousMarketOrder(index).getTradeVolume())));
//    }

    //common
//    private void addFirstMarketOrder() {
//        marketOrders.add(new GenericMarketOrder(
//                calculateFirstMarketOrderPrice(),
//                getFirstOrderVolume()));
//    }

    //common
//    private MarketOrder getPreviousMarketOrder(int index) {
//        return marketOrders.get(index - 1);
//    }

    //unique //add as abstract

    double getFirstOrderVolume() {

        //split tradeVolume evenly to each marketOrder if common ratio is 1
        if(difference == 1) {
            return tradeVolume/totalOrders;
        }

        //derived from sum of finite geometric series formula (Sn=a1(1-rn)1-r, r!=1)
        return (tradeVolume * (1 - difference)) /
                (1 - Math.pow(difference, totalOrders));
    }


    //common
//    private double calculateFirstMarketOrderPrice() {
//        if(type == TradeType.BUY)
//            return maxPrice;
//
//        else
//            return minPrice;
//    }

    //unique //add as abstract
    double getNextOrderVolume(double previousVolume) {
        return previousVolume * difference;
    }

    //common
//    private double getNextMarketOrderPrice(double previousPrice) {
//
//        if(type == TradeType.BUY)
//            return previousPrice - calculateMarketOrderPriceInterval();
//
//        else
//            return previousPrice + calculateMarketOrderPriceInterval();
//    }

    //common
//    private double calculateMarketOrderPriceInterval() {
//        return (maxPrice-minPrice)/(totalOrders - 1);
//    }

    //common
//    @Override
//    public String toString() {
//        StringBuilder stringBuilder = new StringBuilder();
//
//        stringBuilder.append("GeometricTrade{" + "minPrice=")
//                .append(minPrice)
//                .append(", maxPrice=")
//                .append(maxPrice)
//                .append(", difference=")
//                .append(difference)
//                .append(", type=")
//                .append(type)
//                .append(", totalOrders=")
//                .append(totalOrders)
//                .append(", tradeVolume=")
//                .append(tradeVolume)
//                .append(", percentageFee=")
//                .append(percentageFee)
//                .append('}')
//                .append(System.lineSeparator());
//
//        for(MarketOrder order : marketOrders) {
//            stringBuilder.append(order).append(System.lineSeparator());
//        }
//
//        return stringBuilder.toString();
//    }
}
