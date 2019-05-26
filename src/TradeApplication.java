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

        SeqTradeData data = new SequenceTradeData(TradeType.BUY, 505.05050505,
                .7, 10, 8700, 9600);

        Fee fee = new PercentageFee(0);

        PercentageFeeGeometricSequenceTrade trade = new PercentageFeeGeometricSequenceTrade(data, fee);

        TradePresentation presentation = new TwoDecimalTradePresentation(trade.getMarketOrderList());

        presentation.print();
    }
}
