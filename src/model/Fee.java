package model;

import java.math.BigDecimal;

public interface Fee {

    BigDecimal applyTo(BigDecimal value);
}
