package model;

import java.math.BigDecimal;

public class MarketOrder extends BaseEntity implements Comparable<MarketOrder>{

    private BigDecimal assetPrice;
    private BigDecimal orderVolume;

    public MarketOrder(BigDecimal assetPrice,
                       BigDecimal orderVolume) {
        this.assetPrice = assetPrice;
        this.orderVolume = orderVolume;
    }

    public MarketOrder(double assetPrice,
                       double orderVolume) {
        this.assetPrice = BigDecimal.valueOf(assetPrice);
        this.orderVolume = BigDecimal.valueOf(orderVolume);
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
    public int compareTo(MarketOrder other) {
        return assetPrice.compareTo(other.assetPrice);
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
