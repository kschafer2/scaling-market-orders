package fees;

import support.TradeData;

public abstract class Fee implements FeeInt {

    private double value;

    Fee(double value) {
        this.value = value;
    }

    @Override
    public double getValue() {
        return value;
    }
}
