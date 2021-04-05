package domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Amount {

  private final BigDecimal value;

  public Amount(BigDecimal value) {
    this.value = value;
  }

  public boolean isEnoughFor(Amount orderPrice) {
    return value.compareTo(orderPrice.value) >= 0 ;
  }

  public Amount difference(Amount coffeePrice) {
    return new Amount(coffeePrice.value.subtract(value) );
  }

  public BigDecimal value() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Amount amount = (Amount) o;
    return Objects.equals(value, amount.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
