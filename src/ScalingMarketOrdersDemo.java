import model.ManualTrade;
import model.MarketOrder;
import model.Trade;

import java.util.Arrays;
import java.util.List;

import static model.TradeType.BUY;
import static model.TradeType.SELL;

public class ScalingMarketOrdersDemo {

    public static void main(String[] args) {
        List<Trade> trades = Arrays.asList(
                Trade.manual(BUY)
                        .addOrder(new MarketOrder(500, 1000))
                        .addOrder(new MarketOrder(300, 500))
                        .addOrder(new MarketOrder(800, 750))
                        .percentageFee(2),

                Trade.manual(SELL)
                        .addOrder(new MarketOrder(500, 1000))
                        .addOrder(new MarketOrder(300, 500))
                        .addOrder(new MarketOrder(800, 750)),

                Trade.arithmetic(BUY,
                        5,
                        30,
                        50,
                        100,
                        2),

                Trade.arithmetic(SELL,
                        5,
                        30,
                        50,
                        100,
                        2,
                        2),

                Trade.geometric(BUY,
                        5,
                        1000,
                        500.2,
                        1555.65,
                        1.2,
                        3),

                Trade.geometric(SELL,
                        10,
                        5000,
                        100,
                        1500,
                        1)
        );

//        for(Trade trade : trades) {
//            System.out.println(trade);
//            trade.activate();
//            System.out.println(trade + "\n");
//        }

        MarketOrder marketOrder = new MarketOrder(200, 500);
        MarketOrder marketOrder1 = new MarketOrder(500, 1000);
        MarketOrder marketOrder2 = new MarketOrder(300, 500);
        MarketOrder marketOrder3 = new MarketOrder(100, 200);
        MarketOrder marketOrder4 = new MarketOrder(500, 500);
        MarketOrder marketOrder5 = new MarketOrder(500, 100);

        ManualTrade manualTest = Trade.manual(BUY)
                .addOrder(marketOrder)
                .addOrder(marketOrder1)
                .addOrder(marketOrder2)
                .addOrder(marketOrder3)
                .addOrder(marketOrder4)
                .addOrder(marketOrder5);

        System.out.println(manualTest);

        manualTest.deleteOrderById(marketOrder4.getId());

        System.out.println(manualTest);


//        System.out.println(trades.get(0));
//        System.out.println(trades.get(1));
//        System.out.println(trades.get(2));
//        System.out.println(trades.get(3));
//        System.out.println(trades.get(4));
//        System.out.println(trades.get(5));
    }
}
