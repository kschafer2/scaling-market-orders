import Presentation.TradePresentation;
import Presentation.TwoDecimalTradePresentation;
import calculations.GeometricSequenceTradeCalculations;
import calculations.SeqTradeCalculations;
import data.SequenceTradeData;
import data.TradeType;
import fees.PercentageFee;
import orders.MarketOrder;
import trades.PercentageFeeGeometricSequenceTrade;

import java.util.ArrayList;

public class TradeApplication {

    public static void main(String[] args) {

        PercentageFee fee = new PercentageFee(1);

        SequenceTradeData data = new SequenceTradeData(TradeType.BUY, 5000,
                1.2, 20, 1000, 10000);

        SeqTradeCalculations calculations = new GeometricSequenceTradeCalculations(data);

        ArrayList<MarketOrder> marketOrdersList = new ArrayList<MarketOrder>();

        PercentageFeeGeometricSequenceTrade trade = new PercentageFeeGeometricSequenceTrade(marketOrdersList, calculations, fee);

        TradePresentation presentation = new TwoDecimalTradePresentation(trade.getMarketOrderList());

        presentation.print();
    }
}
