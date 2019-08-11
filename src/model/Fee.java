package model;

import java.math.BigDecimal;

public abstract class Fee {

    protected BigDecimal value;
    protected boolean isApplied;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public boolean getIsApplied() {
        return isApplied;
    }

    public void setIsApplied(boolean value) {
        this.isApplied = value;
    }

    abstract BigDecimal applyTo(BigDecimal applyToValue);

}
