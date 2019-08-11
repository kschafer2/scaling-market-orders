package model;

import java.math.BigDecimal;

import static java.math.BigDecimal.ONE;
import static java.math.RoundingMode.HALF_DOWN;

public class PercentageFee extends Fee {

    public PercentageFee(double value) {
        this.value = new BigDecimal(String.valueOf(value));
    }

    public BigDecimal applyTo(BigDecimal applyToValue) {
        if(isApplied) {
            return applyToValue;
        }

            BigDecimal feeValueAsDecimal = value.setScale(value.scale()+2, HALF_DOWN)
                                                .divide(BigDecimal.valueOf(100), HALF_DOWN);

            return applyToValue.divide(ONE.add(feeValueAsDecimal), HALF_DOWN);
    }

}
