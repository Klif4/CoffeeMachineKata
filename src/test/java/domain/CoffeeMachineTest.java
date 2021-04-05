package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CoffeeMachineTest {

  private final CoffeeMachine coffeeMachine = new CoffeeMachine();

  @Test
  void makeOrder_should_return_order_code() {
    Order order = new Order(Drink.COFFEE, Sugar.ONE);
    String orderCode = new CoffeeMachine().makeOrder(order);
    assertThat(orderCode).isEqualTo("C:1:0");
  }

  @Test
  void message_should_return_the_message() {
    String message = coffeeMachine.message("some message ...");
    assertThat(message).isEqualTo("M:some message ...");
  }
}