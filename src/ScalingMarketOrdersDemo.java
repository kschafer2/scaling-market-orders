import factories.TradeFactory;
import model.MarketOrder;
import model.fees.PercentageFee;
import model.trades.Trade;

import java.util.Arrays;
import java.util.List;

import static model.TradeType.BUY;
import static model.TradeType.SELL;

public class ScalingMarketOrdersDemo {

    public static void main(String[] args) {
        List<Trade> trades = Arrays.asList(

                TradeFactory.manual(BUY)
                        .add(new MarketOrder(500, 1000))
                        .add(new MarketOrder(300, 500))
                        .add(new MarketOrder(800, 750))
                        .addFee(new PercentageFee(1)),

                TradeFactory.manual(SELL)
                        .add(new MarketOrder(500, 1000))
                        .add(new MarketOrder(300, 500))
                        .add(new MarketOrder(800, 750)),

                TradeFactory.arithmetic(BUY,
                        5,
                        30,
                        50,
                        100,
                        2),

                TradeFactory.arithmetic(SELL,
                        5,
                        30,
                        50,
                        100,
                        2,
                        new PercentageFee(2)),

                TradeFactory.geometric(BUY,
                        5,
                        1000,
                        500.2,
                        1555.65,
                        1.2,
                        new PercentageFee(3.5)),

                TradeFactory.geometric(SELL,
                        10,
                        5000,
                        100,
                        1500,
                        1)
        );
//
//        ManualTrade trade1 = TradeFactory.manual(BUY)
//                .add(new MarketOrder(500, 300))
//                .add(new MarketOrder(100,100));
//
//        System.out.println(trade1);

        for(Trade trade : trades) {
            System.out.println(trade);
            System.out.println(trade.placeOrders() + "\n");
        }

//        MarketOrder marketOrder = new MarketOrder(200, 500);
//        MarketOrder marketOrder1 = new MarketOrder(500, 1000);
//        MarketOrder marketOrder2 = new MarketOrder(300, 500);
//        MarketOrder marketOrder3 = new MarketOrder(100, 200);
//        MarketOrder marketOrder4 = new MarketOrder(500, 500);
//        MarketOrder marketOrder5 = new MarketOrder(500, 100);
//
//        ManualTrade manualTest = TradeFactory.manual(BUY)
//                .add(marketOrder)
//                .add(marketOrder1)
//                .add(marketOrder2)
//                .add(marketOrder3)
//                .add(marketOrder4)
//                .add(marketOrder5);
//
//        System.out.println(manualTest);
//
//        manualTest.deleteOrderById(marketOrder4.getId());
//
//        System.out.println(manualTest);


//        System.out.println(trades.get(0));
//        System.out.println(trades.get(1));
//        System.out.println(trades.get(2));
//        System.out.println(trades.get(3));
//        System.out.println(trades.get(4));
//        System.out.println(trades.get(5));
    }
}
