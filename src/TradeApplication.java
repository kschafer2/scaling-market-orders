import Presentation.TradePresentation;
import Presentation.TwoDecimalTradePresentation;
import data.SeqTradeData;
import data.SequenceTradeData;
import data.TradeType;
import fees.Fee;
import fees.PercentageFee;
import trades.PercentageFeeGeometricSequenceTrade;

public class TradeApplication {

    public static void main(String[] args) {

        SeqTradeData data = new SequenceTradeData(TradeType.BUY, 1250,
                1, 5, 5367.6, 6351.66);

        Fee fee = new PercentageFee(1);

        PercentageFeeGeometricSequenceTrade trade = new PercentageFeeGeometricSequenceTrade(data, fee);

        TradePresentation presentation = new TwoDecimalTradePresentation(trade.getMarketOrderList());

        presentation.print();
    }
}
