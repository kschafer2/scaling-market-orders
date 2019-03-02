package fees;

public abstract class AbstractFee implements Fee {

    private double value;

    AbstractFee(double value) {
        this.value = value;
    }

    @Override
    public double getValue() {
        return value;
    }
}
