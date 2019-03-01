package orders;

public class BuyMarketOrder extends MarketOrder {

    private double feePercentage;

    public BuyMarketOrder(double assetPrice, double tradeVolume) {
        super(assetPrice, tradeVolume);
    }

}
