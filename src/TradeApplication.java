import Presentation.TradePresentation;
import Presentation.TwoDecimalTradePresentation;
import data.SequenceTradeData;
import data.TradeType;
import fees.PercentageFee;
import trades.PercentageFeeGeometricSequenceTrade;

public class TradeApplication {

    public static void main(String[] args) {

        PercentageFee fee = new PercentageFee(1);
        SequenceTradeData data = new SequenceTradeData(TradeType.BUY, 5000,
                1.2, 20, 1000, 10000);
        PercentageFeeGeometricSequenceTrade trade = new PercentageFeeGeometricSequenceTrade(data, fee);
        TradePresentation presentation = new TwoDecimalTradePresentation(trade.getMarketOrderList());
        presentation.print();
    }
}
