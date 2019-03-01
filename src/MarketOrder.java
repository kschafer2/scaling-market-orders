public abstract class MarketOrder {

    double assetPrice;
    double tradeVolume;

    public MarketOrder(double assetPrice, double tradeVolume) {
        this.assetPrice = assetPrice;
        this.tradeVolume = tradeVolume;
    }

    abstract double getAssetPrice();

    abstract void setAssetPrice(double assetPrice);


}
