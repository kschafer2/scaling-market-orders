package orders;

public class GenericMarketOrder implements MarketOrder {

    private double assetPrice;
    private double tradeVolume;

    public GenericMarketOrder(double assetPrice, double tradeVolume) {
        this.assetPrice = assetPrice;
        this.tradeVolume = tradeVolume;
    }

    @Override
    public double getAssetPrice() {
        return assetPrice;
    }

    @Override
    public void setAssetPrice(double assetPrice) {
        this.assetPrice = assetPrice;
    }

    @Override
    public double getTradeVolume() {
        return tradeVolume;
    }

    @Override
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
