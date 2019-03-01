public class MarketOrderImpl extends MarketOrder{

    public MarketOrderImpl(double assetPrice, double tradeVolume) {
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

    public double getTradeVolume() {
        return tradeVolume;
    }

    public void setTradeVolume(double tradeVolume) {
        this.tradeVolume = tradeVolume;
    }
}
