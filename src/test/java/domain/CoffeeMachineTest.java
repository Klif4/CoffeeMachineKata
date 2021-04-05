package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CoffeeMachineTest {

  private final CoffeeMachine coffeeMachine = new CoffeeMachine();

  @Test
  void order_coffee_with_0_sugar_should_return_C() {
    String order = coffeeMachine.order(Drink.COFFEE, Sugar.ZERO);
    assertThat(order).isEqualTo("C::");
  }

  @Test
  void order_coffee_with_1_sugar_should_return_C10() {
    String order = coffeeMachine.order(Drink.COFFEE, Sugar.ONE);
    assertThat(order).isEqualTo("C:1:0");
  }

  @Test
  void order_coffee_with_2_sugar_should_return_C20() {
    String order = coffeeMachine.order(Drink.COFFEE, Sugar.TWO);
    assertThat(order).isEqualTo("C:2:0");
  }

  @Test
  void order_tea_with_1_sugar_should_return_T10() {
    String order = coffeeMachine.order(Drink.TEA, Sugar.ONE);
    assertThat(order).isEqualTo("T:1:0");
  }

  @Test
  void order_tea_with_2_sugar_should_return_T20() {
    String order = coffeeMachine.order(Drink.TEA, Sugar.TWO);
    assertThat(order).isEqualTo("T:2:0");
  }

  @Test
  void order_tea_with_0_sugar_should_return_T() {
    String order = coffeeMachine.order(Drink.TEA, Sugar.ZERO);
    assertThat(order).isEqualTo("T::");
  }

  @Test
  void order_chocolate_with_1_sugar_should_return_H10() {
    String order = coffeeMachine.order(Drink.CHOCOLATE, Sugar.ONE);
    assertThat(order).isEqualTo("H:1:0");
  }

  @Test
  void order_chocolate_with_2_sugar_should_return_H20() {
    String order = coffeeMachine.order(Drink.CHOCOLATE, Sugar.TWO);
    assertThat(order).isEqualTo("H:2:0");
  }

  @Test
  void order_chocolate_with_0_sugar_should_return_H() {
    String order = coffeeMachine.order(Drink.CHOCOLATE, Sugar.ZERO);
    assertThat(order).isEqualTo("H::");
  }

  @Test
  void message_should_return_the_message() {
    String message = coffeeMachine.message("some message ...");
    assertThat(message).isEqualTo("M:some message ...");
  }
}