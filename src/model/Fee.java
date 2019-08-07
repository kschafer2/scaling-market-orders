package model;

public abstract class Fee {

    double value;
    boolean isApplied;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    abstract void apply(Trade trade);

    abstract void clear();
}
