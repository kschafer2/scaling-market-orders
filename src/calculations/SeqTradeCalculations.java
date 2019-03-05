package calculations;

import data.SeqTradeData;

public interface SeqTradeCalculations extends FirstMarketOrderDependentCalculations {

    SeqTradeData getData();

    void setData(SeqTradeData data);
}
