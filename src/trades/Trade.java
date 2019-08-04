package trades;

import data.TradeType;
import orders.MarketOrder;

import java.util.ArrayList;
import java.util.List;

public abstract class Trade {

    protected TradeType type;
    protected int totalOrders;
    protected double tradeVolume;
    protected double percentageFee;
    protected List<MarketOrder> marketOrders = new ArrayList<>();

    protected Trade(TradeType type){
        this.type = type;
    }

    protected Trade(TradeType type, int totalOrders, double tradeVolume) {
        this.type = type;
        this.totalOrders = totalOrders;
        this.tradeVolume = tradeVolume;
        this.percentageFee = 0;
    }

    protected Trade(TradeType type, int totalOrders, double tradeVolume, double percentageFee) {
        this(type, totalOrders, tradeVolume);
        this.percentageFee = percentageFee;
    }

    private void applyFee() {
        tradeVolume = tradeVolume/(1+(percentageFee/100));
    }

    public Trade activate() {
        applyFee();

        build();

        return this;
    }
    protected abstract void build();

    public static ManualTrade manual(TradeType type) {
        return new ManualTrade(type);
    }

    public static Trade arithmetic(TradeType type, int totalOrders, double tradeVolume,
                                   double minPrice, double maxPrice, double commonDifference) {

        return new ArithmeticTrade(type, totalOrders, tradeVolume, minPrice, maxPrice, commonDifference);
    }

    public static Trade arithmetic(TradeType type, int totalOrders, double tradeVolume,
                                   double minPrice, double maxPrice, double commonDifference, double percentageFee) {

        return new ArithmeticTrade(type, totalOrders, tradeVolume, minPrice, maxPrice, commonDifference, percentageFee);
    }

    public static Trade geometric(TradeType type, int totalOrders, double tradeVolume,
                                  double minPrice, double maxPrice, double commonRatio) {

        return new GeometricTrade(type, totalOrders, tradeVolume, minPrice, maxPrice, commonRatio);
    }

    public static Trade geometric(TradeType type, int totalOrders, double tradeVolume,
                                  double minPrice, double maxPrice, double commonRatio, double percentageFee) {

        return new GeometricTrade(type, totalOrders, tradeVolume, minPrice, maxPrice, commonRatio, percentageFee);
    }

    @Override
    public String toString() {
        return "Trade{" +
                "type=" + type +
                ", totalOrders=" + totalOrders +
                ", tradeVolume=" + tradeVolume +
                ", percentageFee=" + percentageFee +
                ", marketOrders=" + marketOrders +
                '}';
    }
}
