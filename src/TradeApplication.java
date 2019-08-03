import data.TradeType;
import trades.Trade;

public class TradeApplication {

    public static void main(String[] args) {

        //Trade trade = new SequentialTrade.geometric(type,
        //                                            totalOrders,
        //                                            tradeVolume,
        //    sequential trade only:                  minPrice,
        //    sequential trade only:                  maxPrice,
        //    geometric trade only:                   commonRatio,
        //    optional:                               percentageFee);

        Trade trade = Trade.geometric(TradeType.BUY,
                5,
                1000,
                500.2,
                1555.65,
                1.2,
                3);

        System.out.println(trade.toString());
        trade.activate();
        System.out.println(trade.toString());

        Trade trade2 = Trade.geometric(
                TradeType.SELL,
                10,
                5000,
                100,
                1500,
                1
        );

        trade2.activate();
        System.out.println(trade2.toString());

        //Trade trade = new SequentialTrade.arithmetic(type,
        //                                            totalOrders,
        //                                            tradeVolume,
        //     sequential trade only:                 minPrice
        //     sequential trade only:                 maxPrice
        //     arithmetic trade only:                 commonDifference);

        //Trade trade = new ManualTrade()
        //                      .type()
        //                      .percentageFee()
        //                      .addMarketOrder(atPrice, volume)
        //                      .addMarketOrder(atPrice, volume)
        //                      .build()

    }

}
