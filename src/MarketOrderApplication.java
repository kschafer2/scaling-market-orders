import fees.PercentageFee;
import lists.FeeMarketOrderArrayList;
import support.TradeData;
import support.TradeDataImpl;
import support.TradeType;

import java.util.Scanner;

/********************************************************************************
 * 	1. This program first prompts user whether to set buy or sell orders.	    *
 *	2. Then, prompts user for input trade volume, fee as a percentage, number   *
 *	 	of orders, price range as minimum price and maximum price, and scaling  *
 *		ratio. 							    									*
 *	3. Given user input, a list of orders is displayed including price average  *
 *	 	and break even price.												    *
 *********************************************************************************/

public class MarketOrderApplication {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in); //to acquire user input

        double tradeCapital,  //amount of capital desired for the trade
                feePercentage, //percentage of capital reserved for trading fees
                scalingRatio,  //geometric ratio from one order to the next
                //Example: 1.2 increases next order by 20%
                //of the current order
                minPrice,      //smallest order to place
                maxPrice;      //largest order to place

        int orderType,          //to hold user's option to buy or sell
                numberOrders;  //number of orders to place for the trade

        PercentageFee fee = new PercentageFee(1);

        TradeData data = new TradeDataImpl(TradeType.BUY, 5000, 1.2,
                20, 1000, 10000);

        FeeMarketOrderArrayList list = new FeeMarketOrderArrayList(data, fee);
    }


/********************************************************************************

        DisplayMenu();
        orderType = keyboard.nextInt();

        System.out.print("\nFollow the prompts to determine your market orders.\n"
                + "Trade Capital: ");
        tradeCapital = keyboard.nextDouble();

        System.out.print("\nFee Percentage: ");
        feePercentage = keyboard.nextDouble();

        System.out.print("\nNumber of market orders: ");
        numberOrders = keyboard.nextInt();

        System.out.print("\nScaling ratio: ");
        scalingRatio = keyboard.nextDouble();

          System.out.print("\nMaximum price: ");
          maxPrice = keyboard.nextDouble();

         System.out.print("\nMinimum price: ");
          minPrice = keyboard.nextDouble();

            MarketOrderListOriginal orderList = new MarketOrderListOriginal(orderType, numberOrders, tradeCapital, scalingRatio,
                                                            maxPrice, minPrice, feePercentage);
            orderList.printListAndWeightedAverage();
    }

/**
 try {
 java.awt.Desktop.getDesktop().browse(new URI("https://exchange.gemini.com/signin"));
 } catch (IOException e) {
 // TODO Auto-generated catch block
 e.printStackTrace();
 } catch (URISyntaxException e) {
 // TODO Auto-generated catch block
 e.printStackTrace();
 }
 **/

    /********************************************************************************
     * 	Function: DisplayMenu														*
     * 																				*
     * 	1. Displays welcome menu with options to buy or sell.					    *
     *	2. Prompts user to enter 1 for buy orders or 2 for sell orders.				*		    									*
     *********************************************************************************/

    public static void DisplayMenu()
    {
        System.out.print("         *** Welcome to the Order Setter ***\n"
                +" Please enter 1 for buy orders or 2 for sell orders.\n\n"

                + "Buy or sell?: ");
    }



}