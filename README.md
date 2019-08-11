# Scaling Market Orders
Experimental trade builder for market trading. Create a list of market orders with your own startegy or with a scaling strategy.

## How to Run:
Clone this repository to your local machine. Open as a project in your favorite IDE, build, and run! Currently, there's no user interface, so you must modify the main method to create and output a Trade.

# Features
## TradeFactory Class
Create a new instance of the TradeFactory class to access methods for the creating different types of Trades. A Trade contains a list of Market Orders and metadata about the market orders list. A Market Order has both Asset Price and Order Volume fields. The Asset Price field is the price of the asset at which the Market Order should execute, and the Order Volume field is the amount of starting currency to trade for the asset at the Asset Price.

## Manual Trade
The ManualTrade class allows the user to The ManualTrade class may be instantiated via the TradeFactory method 'manual.' A ManualTrade allows the user to add both Market Orders and a Fee. A Fee subtracts an certain amount from the Total Volume of a trade.

## Arithmetic Scaling Trade
An Arithmetic Trade generates an arithmetic scaling Market Order list according to the data supplied by the user during creation. The user must supply a common difference, or difference between each order price, when the Arithmetic Trade is created.

## Geometric Scaling Trade
A Geometric Trade generates a geometric scaling Market Order list according to the data supplied by the user during creation. The user must supply a common ratio, or the ratio between each order price, when the Arithmetic Trade is created.

