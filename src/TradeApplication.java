import Presentation.TradePresentation;
import Presentation.TwoDecimalTradePresentation;
import data.GeometricScalingTradeData;
import data.TradeType;
import fees.PercentageFee;
import trades.PercentageFeeGeometricScalableTrade;

public class TradeApplication {

    public static void main(String[] args) {

        PercentageFee fee = new PercentageFee(1);
        GeometricScalingTradeData data = new GeometricScalingTradeData(TradeType.BUY, 5000,
                1.2, 20, 1000, 10000);
        PercentageFeeGeometricScalableTrade trade = new PercentageFeeGeometricScalableTrade(data, fee);
        TradePresentation presentation = new TwoDecimalTradePresentation(trade.getMarketOrderList());
        presentation.print();
    }
}
