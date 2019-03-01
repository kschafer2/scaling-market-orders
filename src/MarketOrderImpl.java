public class MarketOrderImpl {

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

    double getAssetPrice() {
        return assetPrice;
    }

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
