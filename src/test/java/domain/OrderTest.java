package domain;

import static domain.Drink.CHOCOLATE;
import static domain.Drink.COFFEE;
import static domain.Drink.TEA;
import static domain.Sugar.ONE;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class OrderTest {

  @Test
  void coffee_with_0_sugar_should_return_C() {
    Order order = new Order(COFFEE, Sugar.ZERO);
    assertThat(order.code()).isEqualTo("C::");
  }

  @Test
  void coffee_with_1_sugar_should_return_C10() {
    Order order = new Order(COFFEE, ONE);
    assertThat(order.code()).isEqualTo("C:1:0");
  }

  @Test
  void coffee_with_2_sugar_should_return_C20() {
    Order order = new Order(COFFEE, Sugar.TWO);
    assertThat(order.code()).isEqualTo("C:2:0");
  }

  @Test
  void tea_with_0_sugar_should_return_T() {
    Order order = new Order(Drink.TEA, Sugar.ZERO);
    assertThat(order.code()).isEqualTo("T::");
  }

  @Test
  void tea_with_1_sugar_should_return_T10() {
    Order order = new Order(Drink.TEA, ONE);
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
    Order order = new Order(Drink.CHOCOLATE, ONE);
    assertThat(order.code()).isEqualTo("H:1:0");
  }

  @Test
  void chocolate_with_2_sugar_should_return_H20() {
    Order order = new Order(Drink.CHOCOLATE, Sugar.TWO);
    assertThat(order.code()).isEqualTo("H:2:0");
  }

  @Test
  void coffee_price_should_be_0dot6() {
    Amount price = new Order(COFFEE, ONE).price();
    assertThat(price).isEqualTo(new Amount(new BigDecimal("0.6")));
  }

  @Test
  void tea_price_should_be_0dot4() {
    Amount price = new Order(TEA, ONE).price();
    assertThat(price).isEqualTo(new Amount(new BigDecimal("0.4")));
  }

  @Test
  void chocolate_price_should_be_0dot5() {
    Amount price = new Order(CHOCOLATE, ONE).price();
    assertThat(price).isEqualTo(new Amount(new BigDecimal("0.5")));
  }
}