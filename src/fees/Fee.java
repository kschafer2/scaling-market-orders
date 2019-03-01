package fees;

import orders.MarketOrder;

public abstract class Fee {

    private double value;

    Fee(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public abstract double calculateFee();
}
