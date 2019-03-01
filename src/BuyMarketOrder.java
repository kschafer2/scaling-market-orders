public class BuyMarketOrder extends MarketOrder {

    private double feePercentage;

    public BuyMarketOrder(double assetPrice, double tradeVolume) {
        super(assetPrice, tradeVolume);
    }

    @Override
    public double getAssetPrice() {
        return assetPrice;
    }

    @Override
    public void setAssetPrice(double assetPrice) {

    }
}
