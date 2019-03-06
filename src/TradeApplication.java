import Presentation.TradePresentation;
import Presentation.TwoDecimalTradePresentation;
import data.SeqTradeData;
import data.SequenceTradeData;
import data.TradeType;
import fees.Fee;
import fees.PercentageFee;
import trades.AbstractTrade;
import trades.PercentageFeeGeometricSequenceTrade;

public class TradeApplication {

    public static void main(String[] args) {

        SeqTradeData data = new SequenceTradeData(TradeType.BUY, 5000,
                1.2, 20, 1000, 10000);

        Fee fee = new PercentageFee(1);

        AbstractTrade trade = new PercentageFeeGeometricSequenceTrade(data, fee);

        TradePresentation presentation = new TwoDecimalTradePresentation(trade.getMarketOrderList());

        presentation.print();
    }
}
