package orders;

import fees.AbstractFee;

public class FeeMarketOrder extends GenericMarketOrder {

    private AbstractFee fee;

    public FeeMarketOrder(double assetPrice, double tradeVolume, AbstractFee fee) {
        super(assetPrice, tradeVolume);
        this.fee = fee;

        applyFee();
    }

    private void applyFee() {
        setTradeVolume(getTradeVolume()/(1 + fee.calculateFee()));
    }
}
