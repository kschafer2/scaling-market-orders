package orders;

public class SellMarketOrder extends MarketOrder {

    public SellMarketOrder(double assetPrice, double tradeVolume) {
        super(assetPrice, tradeVolume);
    }

    @Override
    public double getAssetPrice() {
        return assetPrice;
    }

    @Override
    public void setAssetPrice(double assetPrice) {
        this.assetPrice = assetPrice;
    }
}
