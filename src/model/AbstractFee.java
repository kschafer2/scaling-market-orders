package model;

import java.math.BigDecimal;

public abstract class AbstractFee implements Fee {

    protected BigDecimal value;
    protected boolean isApplied;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public boolean isApplied() {
        return isApplied;
    }

    public void isApplied(boolean value) {
        this.isApplied = value;
    }

}
