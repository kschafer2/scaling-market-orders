package model;

import java.math.BigDecimal;

public abstract class Fee {

    BigDecimal value;
    boolean isApplied;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    abstract BigDecimal applyTo(BigDecimal applyToValue);

    abstract void clear();
}
