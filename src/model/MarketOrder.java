package model;

public class MarketOrder {

    private double assetPrice;
    private double tradeVolume;

    public MarketOrder(double assetPrice, double tradeVolume) {
        this.assetPrice = assetPrice;
        this.tradeVolume = tradeVolume;
    }

    public double getAssetPrice() {
        return assetPrice;
    }

    public void setAssetPrice(double assetPrice) {
        this.assetPrice = assetPrice;
    }

    public double getTradeVolume() {
        return tradeVolume;
    }

    public void setTradeVolume(double tradeVolume) {
        this.tradeVolume = tradeVolume;
    }

    @Override
    public String toString() {
        return
                "assetPrice=" + assetPrice +
                ", tradeVolume=" + tradeVolume;
    }
}
