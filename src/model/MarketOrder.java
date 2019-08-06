package model;

public class MarketOrder extends BaseEntity{

    private double assetPrice;
    private double orderVolume;

    public MarketOrder(double assetPrice, double orderVolume) {
        this.assetPrice = assetPrice;
        this.orderVolume = orderVolume;
    }

    public double getAssetPrice() {
        return assetPrice;
    }

    public void setAssetPrice(double assetPrice) {
        this.assetPrice = assetPrice;
    }

    public double getOrderVolume() {
        return orderVolume;
    }

    public void setOrderVolume(double orderVolume) {
        this.orderVolume = orderVolume;
    }

    @Override
    public String toString() {
        return "MarketOrder{" +
                "id=" + id +
                ", assetPrice=" + assetPrice +
                ", orderVolume=" + orderVolume +
                '}';
    }
}
