package trades;

import fees.Fee;

public class AbstractFeeTrade extends AbstractTrade {

    private Fee fee;

    double applyFee() {
        fee.calculateFee();

        return fee.getFee();
    };
}
