package model;

import java.math.BigDecimal;

public class MarketOrder extends BaseEntity{

    private BigDecimal assetPrice;
    private BigDecimal orderVolume;

    public MarketOrder(BigDecimal assetPrice, BigDecimal orderVolume) {
        this.assetPrice = assetPrice;
        this.orderVolume = orderVolume;
    }

    public MarketOrder(double assetPrice, double orderVolume) {
        this.assetPrice = new BigDecimal(String.valueOf(assetPrice));
        this.orderVolume = new BigDecimal(String.valueOf(orderVolume));
    }

    public BigDecimal getAssetPrice() {
        return assetPrice;
    }

    public void setAssetPrice(BigDecimal assetPrice) {
        this.assetPrice = assetPrice;
    }

    public BigDecimal getOrderVolume() {
        return orderVolume;
    }

    public void setOrderVolume(BigDecimal orderVolume) {
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
