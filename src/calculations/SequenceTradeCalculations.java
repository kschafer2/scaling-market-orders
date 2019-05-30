package calculations;

import data.SeqTradeData;

public interface SequenceTradeCalculations extends TradeCalculations<SeqTradeData> {

    double calculateFirstMarketOrderVolume();

    double calculateFirstMarketOrderPrice();

    double calculateNextMarketOrderVolume(double previousVolume);

    double calculateNextMarketOrderPrice(double previousPrice);
}
