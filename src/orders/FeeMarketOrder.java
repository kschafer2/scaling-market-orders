package orders;

import fees.Fee;

public class FeeMarketOrder extends MarketOrder {

    private Fee fee;

    public FeeMarketOrder(double assetPrice, double tradeVolume, Fee fee) {
        super(assetPrice, tradeVolume);
        this.fee = fee;

        applyFee();
    }

    public void applyFee() {
        setTradeVolume(getTradeVolume()/(1 + fee.calculateFee()));
    }
}
