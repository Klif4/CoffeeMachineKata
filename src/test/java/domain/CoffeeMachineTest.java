package domain;

import static domain.Drink.COFFEE;
import static domain.Sugar.ONE;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class CoffeeMachineTest {

  private final CoffeeMachine coffeeMachine = new CoffeeMachine();

  @Test
  void message_should_return_the_message() {
    String message = coffeeMachine.message("some message ...");
    assertThat(message).isEqualTo("M:some message ...");
  }

  @Test
  void customer_have_enough_money_to_make_order() {
    Order order = new Order(COFFEE, ONE);
    String orderMessage = new CoffeeMachine().makeOrder(order, new Amount(new BigDecimal("1.0")));
    assertThat(orderMessage).isEqualTo("C:1:0");
  }

  @Test
  void customer_does_not_have_enough_money_to_make_order() {
    Order order = new Order(COFFEE, ONE);
    String orderMessage = new CoffeeMachine().makeOrder(order, new Amount(new BigDecimal("0.2")));
    assertThat(orderMessage).isEqualTo("M:Missing 0.4");
  }
}