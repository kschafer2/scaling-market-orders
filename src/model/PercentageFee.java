package model;

public class PercentageFee implements Fee {

    private double value;
    private boolean isApplied;

    @Override
    public Trade applyFee(Trade trade) {
        if(!isApplied) {
            trade.totalVolume = trade.totalVolume / (1 + (trade.percentageFee / 100));

            isApplied = true;
        }

        return trade;
    }
}
