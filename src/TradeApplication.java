import data.SeqTradeData;
import data.SequenceTradeData;
import data.TradeType;
import fees.Fee;
import fees.PercentageFee;
import trades.PercentageFeeGeometricSequenceTrade;

public class TradeApplication {

    public static void main(String[] args) {

        SeqTradeData data = new SequenceTradeData(TradeType.BUY, 1203.2,1,20, 5700, 7400
                 );

        Fee fee = new PercentageFee(1);

        PercentageFeeGeometricSequenceTrade trade = new PercentageFeeGeometricSequenceTrade(data, fee);
        trade.build();

       // TradePresentation presentation = new TwoDecimalTradePresentation(trade.getMarketOrderList());

       // presentation.print();

        //Trade trade = new SequentialTrade.Geometric(type,
        //                                            numberOfMarketOrders,
        //                                            tradeVolume,
        //    sequential trade only:                  minMarketOrderPrice,
        //    sequential trade only:                  maxMarketOrderPrice,
        //    geometric trade only:                   commonRatio,
        //    optional:                               fee);

        //Trade trade = new SequentialTrade.Arithmetic(type,
        //                                            numberOfMarketOrders,
        //                                            tradeVolume,
        //     sequential trade only:                 minMarketOrderPrice
        //     sequential trade only:                 maxMarketOrderPrice
        //     arithmetic trade only:                 commonDifference);

        //Trade trade = new ManualTrade()
        //                      .type()
        //                      .fee()
        //                      .addMarketOrder(atPrice, volume)
        //                      .addMarketOrder(atPrice, volume)
        //                      .build()

    }

}
