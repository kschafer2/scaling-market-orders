package trades;

import fees.Fee;

public class FeeTrade extends Trade {

    private Fee fee;

    double applyFee() {
        fee.calculateFee();

        return fee.getFee();
    }
}
