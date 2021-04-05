package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class AmountTest {

  public static final Amount COFFEE_PRICE = new Amount(new BigDecimal("0.6"));

  @Test
  void isEnoughFor_true_when_customer_money_greater_than_order_price() {
    Amount customerMoney = new Amount(new BigDecimal("2.0"));

    boolean enoughForOrder = customerMoney.isEnoughFor(COFFEE_PRICE);

    assertThat(enoughForOrder).isTrue();
  }

  @Test
  void isEnoughFor_true_when_customer_money_equal_to_order_price() {
    Amount customerMoney = new Amount(new BigDecimal("0.6"));

    boolean enoughForOrder = customerMoney.isEnoughFor(COFFEE_PRICE);

    assertThat(enoughForOrder).isTrue();
  }

  @Test
  void isEnoughFor_false_when_customer_money_lower_than_order_price() {
    Amount customerMoney = new Amount(new BigDecimal("0.3"));

    boolean enoughForOrder = customerMoney.isEnoughFor(COFFEE_PRICE);

    assertThat(enoughForOrder).isFalse();
  }

  @Test
  void difference_between_order_price_and_customer_money() {
    Amount customerMoney = new Amount(new BigDecimal("0.3"));

    Amount difference = customerMoney.difference(COFFEE_PRICE);

    assertThat(difference).isEqualTo(new Amount(new BigDecimal("0.3")));
  }
}