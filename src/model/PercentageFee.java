package model;

public class PercentageFee extends Fee {

    public PercentageFee(double value) {
        this.value = value;
    }

    @Override
    public void apply(Trade trade) {
        if(!isApplied) {
            trade.totalVolume = trade.totalVolume / (1 + (value / 100));

            isApplied = true;
        }
    }

    @Override
    public void clear() {
        isApplied = false;
    }
}
