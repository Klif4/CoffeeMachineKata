package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class OrderTest {

  @Test
  void coffee_with_0_sugar_should_return_C() {
    Order order = new Order(Drink.COFFEE, Sugar.ZERO);
    assertThat(order.code()).isEqualTo("C::");
  }

  @Test
  void coffee_with_1_sugar_should_return_C10() {
    Order order = new Order(Drink.COFFEE, Sugar.ONE);
    assertThat(order.code()).isEqualTo("C:1:0");
  }

  @Test
  void coffee_with_2_sugar_should_return_C20() {
    Order order = new Order(Drink.COFFEE, Sugar.TWO);
    assertThat(order.code()).isEqualTo("C:2:0");
  }

  @Test
  void tea_with_0_sugar_should_return_T() {
    Order order = new Order(Drink.TEA, Sugar.ZERO);
    assertThat(order.code()).isEqualTo("T::");
  }

  @Test
  void tea_with_1_sugar_should_return_T10() {
    Order order = new Order(Drink.TEA, Sugar.ONE);
    assertThat(order.code()).isEqualTo("T:1:0");
  }

  @Test
  void tea_with_2_sugar_should_return_T20() {
    Order order = new Order(Drink.TEA, Sugar.TWO);
    assertThat(order.code()).isEqualTo("T:2:0");
  }

  @Test
  void chocolate_with_0_sugar_should_return_H() {
    Order order = new Order(Drink.CHOCOLATE, Sugar.ZERO);
    assertThat(order.code()).isEqualTo("H::");
  }

  @Test
  void chocolate_with_1_sugar_should_return_H10() {
    Order order = new Order(Drink.CHOCOLATE, Sugar.ONE);
    assertThat(order.code()).isEqualTo("H:1:0");
  }

  @Test
  void chocolate_with_2_sugar_should_return_H20() {
    Order order = new Order(Drink.CHOCOLATE, Sugar.TWO);
    assertThat(order.code()).isEqualTo("H:2:0");
  }

}