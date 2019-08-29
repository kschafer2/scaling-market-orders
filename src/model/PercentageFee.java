package model;

import java.math.BigDecimal;

import static java.math.BigDecimal.ONE;
import static java.math.RoundingMode.HALF_DOWN;

public class PercentageFee extends AbstractFee {

    public PercentageFee(double value) {
        this.value = BigDecimal.valueOf(value);
    }

    @Override
    public BigDecimal applyTo(BigDecimal applyToValue) {
        if(isApplied) {
            return applyToValue;
        }

        BigDecimal feeValueAsDecimal = value.setScale(value.scale()+2, HALF_DOWN)
                .divide(BigDecimal.valueOf(100), HALF_DOWN);

        return applyToValue.divide(ONE.add(feeValueAsDecimal), HALF_DOWN);
    }
}
