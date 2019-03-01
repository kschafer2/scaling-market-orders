import java.text.DecimalFormat;

public class MarketOrderList {
    public static final int BUY = 1;
    public static final int SELL = 2;

    private int numberOfMarketOrders;
    private int marketOrderType;

    MarketOrder[] marketOrders;

    private double totalTradeCapital;
    private double scalingRatio;
    private double maxMarketOrderPrice;
    private double minMarketOrderPrice;
    private double feePercentage;


    MarketOrderList(int marketOrderType, int numberOfMarketOrders, double totalTradeCapital, double scalingRatio,
                    double maxMarketOrderPrice, double minMarketOrderPrice, double feePercentage) {

        this.marketOrderType = marketOrderType;
        this.numberOfMarketOrders = numberOfMarketOrders;

        this.marketOrders = new MarketOrder[numberOfMarketOrders];

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

        MarketOrder firstMarketOrder = new MarketOrder(firstMarketOrderPrice, getFirstOrderCapital());

        marketOrders[0] = firstMarketOrder;
    };

    void setThisMarketOrder(int currentIndex) {
        double priceInterval = getPriceInterval();

        if(marketOrderType == BUY)
            priceInterval /= -1;

        MarketOrder thisMarketOrder = new MarketOrder(getPreviousMarketOrder(currentIndex).getAssetPrice()
                + priceInterval, getPreviousMarketOrder(currentIndex).getDollarVolume() * scalingRatio);

        marketOrders[currentIndex] = thisMarketOrder;
    };

    double getPriceInterval() {

        double priceInterval = (maxMarketOrderPrice-minMarketOrderPrice)/(numberOfMarketOrders - 1);

        return priceInterval;
    }

     MarketOrder getPreviousMarketOrder(int currentIndex) {
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

        for(int i = 0; i < marketOrders.length; i++) {
            System.out.println(numberFormat.format(marketOrders[i].getAssetPrice()) + "\t"
                    + marketOrders[i].getDollarVolume());
        }
    }

    double weightedAverage() {
        double sumProduct = 0;
        double sum = 0;


        for(int i = 0; i < marketOrders.length; i++) {
            sumProduct += (marketOrders[i].getAssetPrice() * marketOrders[i].getDollarVolume());
            sum += marketOrders[i].getDollarVolume();
        }

        return sumProduct/sum;
    }

    void printListAndWeightedAverage() {
        printList();
        System.out.println("\nWeighted Average: " + weightedAverage());
    }
}
