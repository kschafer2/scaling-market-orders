package fees;

public class PercentageFee extends Fee {

    public PercentageFee(double value) {
        super(value);
    }

    @Override
    public double calculateFee() {
         return (getValue()/100);
    }
}
