import model.MarketOrder;
import model.Trade;

import static model.TradeType.BUY;
import static model.TradeType.SELL;

public class TradeApplication {

    public static void main(String[] args) {

        //Trade trade = new SequentialTrade.geometric(type,
        //                                            totalOrders,
        //                                            tradeVolume,
        //    sequential trade only:                  minPrice,
        //    sequential trade only:                  maxPrice,
        //    geometric trade only:                   commonRatio,
        //    optional:                               percentageFee);

        Trade trade = Trade.geometric(
                        BUY,
                        5,
                        1000,
                        500.2,
                        1555.65,
                        1.2,
                        3);

//        System.out.println(trade);
//        trade.activate();
//        System.out.println(trade);

        Trade trade2 = Trade.geometric(
                            SELL,
                            10,
                            5000,
                            100,
                            1500,
                            1)
                            .activate();

//           System.out.println(trade2);

        Trade trade3 = Trade.manual(BUY)
                            .addOrder(new MarketOrder(500, 1000))
                            .addOrder(new MarketOrder(300, 500))
                            .addOrder(new MarketOrder(800, 750))
                            .percentageFee(2)
                            .activate();

        Trade trade4 = Trade.manual(SELL)
                            .addOrder(new MarketOrder(500, 1000))
                            .addOrder(new MarketOrder(300, 500))
                            .addOrder(new MarketOrder(800, 750))
                            .activate();

//        System.out.println(trade3);
//        System.out.println(trade4);

        Trade trade5 = Trade.arithmetic(BUY,
                                        5,
                                        30,
                                        0,
                                        100,
                                        2,
                                        2)
                                        .activate();

        System.out.println(trade5);

        //Trade trade = new ManualTrade()
        //                      .type()
        //                      .percentageFee()
        //                      .addMarketOrder(atPrice, volume)
        //                      .addMarketOrder(atPrice, volume)
        //                      .build()

    }

}
