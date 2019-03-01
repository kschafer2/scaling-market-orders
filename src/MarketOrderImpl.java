public class MarketOrderImpl implements MarketOrder{

    private double assetPrice;
    private double dollarVolume;

    MarketOrderImpl() {
        this.assetPrice = 0;
        this.dollarVolume = 0;
    }

    MarketOrderImpl(double assetPrice, double dollarVolume) {
        this.assetPrice = assetPrice;
        this.dollarVolume = dollarVolume;
    }
    @Override
    public double getAssetPrice() {
        return assetPrice;
    }
    @Override
    public void setAssetPrice(double assetPrice) {
        this.assetPrice = assetPrice;
    }

    public double getDollarVolume() {
        return dollarVolume;
    }

    public void setDollarVolume(double dollarVolume) {
        this.dollarVolume = dollarVolume;
    }
}
