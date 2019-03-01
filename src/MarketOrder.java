public class MarketOrder {

    private double assetPrice;
    private double dollarVolume;

    MarketOrder() {
        this.assetPrice = 0;
        this.dollarVolume = 0;
    }

    MarketOrder(double assetPrice, double dollarVolume) {
        this.assetPrice = assetPrice;
        this.dollarVolume = dollarVolume;
    }

    public double getAssetPrice() {
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
