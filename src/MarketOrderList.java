import java.text.DecimalFormat;

public class MarketOrderList {
    private static final int BUY = 1;
    private static final int SELL = 2;

    private int numberOfMarketOrders;
    private int marketOrderType;

    private MarketOrderImpl[] marketOrders;

    private double totalTradeCapital;
    private double scalingRatio;
    private double maxMarketOrderPrice;
    private double minMarketOrderPrice;
    private double feePercentage;


    MarketOrderList(int marketOrderType, int numberOfMarketOrders, double totalTradeCapital, double scalingRatio,
                    double maxMarketOrderPrice, double minMarketOrderPrice, double feePercentage) {

        this.marketOrderType = marketOrderType;
        this.numberOfMarketOrders = numberOfMarketOrders;

        this.marketOrders = new MarketOrderImpl[numberOfMarketOrders];

        if(this.marketOrderType == SELL)
            this.feePercentage = 0;
        else
            this.feePercentage = feePercentage;

            this.totalTradeCapital = applyFee(totalTradeCapital);

        this.scalingRatio = scalingRatio;
        this.maxMarketOrderPrice = maxMarketOrderPrice;
        this.minMarketOrderPrice = minMarketOrderPrice;

        buildOrderList();
    }

    private void convertFeeToDecimal() { //convert percentage to decimal value
        feePercentage = feePercentage/100;
    }

    private double applyFee(double totalTradeCapital) {
        if (feePercentage <= 0)
            return totalTradeCapital;

        convertFeeToDecimal();

        if(marketOrderType == BUY) {
            totalTradeCapital /= (1 + feePercentage);
        }
        else if(marketOrderType == SELL)
            totalTradeCapital *= (1+ feePercentage);

        return totalTradeCapital;
    }

    double getFirstOrderCapital() {

        return (this.totalTradeCapital*(1-this.scalingRatio))/
                (1-Math.pow(this.scalingRatio, this.numberOfMarketOrders));
    }

    void setFirstMarketOrder() {
        double firstMarketOrderPrice;

        if (marketOrderType == BUY)
            firstMarketOrderPrice = maxMarketOrderPrice;
        else
            firstMarketOrderPrice = minMarketOrderPrice;

        MarketOrderImpl firstMarketOrder = new MarketOrderImpl(firstMarketOrderPrice, getFirstOrderCapital());

        marketOrders[0] = firstMarketOrder;
    }

    void setThisMarketOrder(int currentIndex) {
        double priceInterval = getPriceInterval();

        if(marketOrderType == BUY)
            priceInterval /= -1;

        MarketOrderImpl thisMarketOrder = new MarketOrderImpl(getPreviousMarketOrder(currentIndex).getAssetPrice()
                + priceInterval, getPreviousMarketOrder(currentIndex).getTradeVolume() * scalingRatio);

        marketOrders[currentIndex] = thisMarketOrder;
    }

    double getPriceInterval() {

        return (maxMarketOrderPrice-minMarketOrderPrice)/(numberOfMarketOrders - 1);
    }

     MarketOrderImpl getPreviousMarketOrder(int currentIndex) {
         return marketOrders[currentIndex - 1];
     }

    void buildOrderList() {
        setFirstMarketOrder();

        for(int i = 1; i < marketOrders.length; i++) {
            setThisMarketOrder(i);
        }
    }

    void printList() {
        DecimalFormat numberFormat = new DecimalFormat("#.00");

        for (MarketOrderImpl marketOrder : marketOrders) {
            System.out.println(numberFormat.format(marketOrder.getAssetPrice()) + "\t"
                    + marketOrder.getTradeVolume());
        }
    }

    double weightedAverage() {
        double sumProduct = 0;
        double sum = 0;


        for (MarketOrderImpl marketOrder : marketOrders) {
            sumProduct += (marketOrder.getAssetPrice() * marketOrder.getTradeVolume());
            sum += marketOrder.getTradeVolume();
        }

        return sumProduct/sum;
    }

    void printListAndWeightedAverage() {
        printList();
        System.out.println("\nWeighted Average: " + weightedAverage());
    }
}
