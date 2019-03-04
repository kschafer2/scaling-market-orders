package fees;

public class PercentageFee extends AbstractFee {

    public PercentageFee(double value) {
        super(value);
    }

    @Override
    public double calculateFee() {
         return (getFee()/100);
    }
}