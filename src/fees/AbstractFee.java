package fees;

public abstract class AbstractFee implements Fee {

    private double fee;

    AbstractFee(double fee) {
        this.fee = fee;
    }

    @Override
    public double getFee() {
        return fee;
    }

}
