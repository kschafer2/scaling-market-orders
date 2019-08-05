import model.MarketOrder;
import model.Trade;

import java.util.Arrays;
import java.util.List;

import static model.TradeType.BUY;
import static model.TradeType.SELL;

public class TradeApplication {

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

        for(Trade trade : trades) {
            System.out.println(trade);
            trade.activate();
            System.out.println(trade + "\n");
        }
    }
}
