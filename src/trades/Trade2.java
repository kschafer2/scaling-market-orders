package trades;

import data.TradeType;
import orders.MarketOrder;

import java.util.ArrayList;
import java.util.List;

public abstract class Trade2 {

    protected TradeType type;
    protected int totalOrders;
    protected double tradeVolume;
    protected double percentageFee;
    protected List<MarketOrder> marketOrders = new ArrayList<>();

    protected Trade2(TradeType type, int totalOrders, double tradeVolume) {
        this.type = type;
        this.totalOrders = totalOrders;
        this.tradeVolume = tradeVolume;
        this.percentageFee = 0;
    }

    protected Trade2(TradeType type, int totalOrders, double tradeVolume, double percentageFee) {
        this(type, totalOrders, tradeVolume);
        this.percentageFee = percentageFee;
    }

    private void applyFee() {
        tradeVolume = tradeVolume/(1+(percentageFee/100));
    }

    public void activate() {
        applyFee();
        build();
    }

    protected abstract void build();

    public static Trade2 arithmetic(TradeType type, int totalOrders, double tradeVolume,
                                   double minPrice, double maxPrice, double commonDifference) {

        return new ArithmeticTrade(type, totalOrders, tradeVolume, minPrice, maxPrice, commonDifference);
    }

    public static Trade2 arithmetic(TradeType type, int totalOrders, double tradeVolume,
                                   double minPrice, double maxPrice, double commonDifference, double fee) {

        return new ArithmeticTrade(type, totalOrders, tradeVolume, minPrice, maxPrice, commonDifference, fee);    }

    public static Trade2 geometric(TradeType type, int totalOrders, double tradeVolume,
                                  double minPrice, double maxPrice, double commonRatio) {

        return new GeometricTrade(type, totalOrders, tradeVolume, minPrice, maxPrice, commonRatio);
    }

    public static Trade2 geometric(TradeType type, int totalOrders, double tradeVolume,
                                  double minPrice, double maxPrice, double commonRatio, double fee) {

        return new GeometricTrade(type, totalOrders, tradeVolume, minPrice, maxPrice, commonRatio, fee);
    }
}
