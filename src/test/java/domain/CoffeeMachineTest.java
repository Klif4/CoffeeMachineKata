package domain;

import static domain.Drink.COFFEE;
import static domain.Sugar.ONE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.never;

import domain.ports.Reporting;
import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class CoffeeMachineTest {

  @Mock
  private Reporting reporting;

  private CoffeeMachine coffeeMachine;

  @BeforeEach
  void setUp() {
    coffeeMachine = new CoffeeMachine(reporting);
  }

  @Test
  void message_should_return_the_message() {
    String message = coffeeMachine.message("some message ...");
    assertThat(message).isEqualTo("M:some message ...");
  }

  @Test
  void customer_have_enough_money_to_make_order_should_send_order_message_and_report() {
    Order order = new Order(COFFEE, ONE);
    String orderMessage = coffeeMachine.makeOrder(order, new Amount(new BigDecimal("1.0")));
    assertThat(orderMessage).isEqualTo("C:1:0");
    then(reporting).should().report(order);
  }

  @Test
  void customer_does_not_have_enough_money_to_make_order_and_not_report() {
    Order order = new Order(COFFEE, ONE);
    String orderMessage = coffeeMachine.makeOrder(order, new Amount(new BigDecimal("0.2")));
    assertThat(orderMessage).isEqualTo("M:Missing 0.4");
    then(reporting).should(never()).report(order);
  }
}