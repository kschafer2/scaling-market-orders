import calculations.GeometricScalingTradeCalculations;
import data.GeometricScalingTradeData;
import data.TradeData;
import data.TradeType;
import fees.Fee;
import fees.PercentageFee;
import trades.PercentageFeeGeometricScalableTrade;

public class TradeApplication {

    public static void main(String[] args) {

        PercentageFee fee = new PercentageFee(1);
        GeometricScalingTradeData data = new GeometricScalingTradeData(TradeType.BUY, 5000,
                1.2, 20, 1000, 10000);
        PercentageFeeGeometricScalableTrade trade = new PercentageFeeGeometricScalableTrade(data, fee);
       // trade.build();
    }
}
