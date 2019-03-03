package orders;

import fees.AbstractFee;

public class FeeMarketOrder extends AbstractMarketOrder {

    private AbstractFee fee;

    public FeeMarketOrder(double assetPrice, double tradeVolume, AbstractFee fee) {
        super(assetPrice, tradeVolume);
        this.fee = fee;

        applyFee();
    }

    public void applyFee() {
        setTradeVolume(getTradeVolume()/(1 + fee.calculateFee()));
    }
}
