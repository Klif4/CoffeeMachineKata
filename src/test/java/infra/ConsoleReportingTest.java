package infra;

import static domain.Drink.CHOCOLATE;
import static domain.Drink.COFFEE;
import static domain.Drink.HOT_TEA;
import static domain.Drink.ORANGE_JUICE;
import static domain.Drink.TEA;
import static domain.Sugar.ONE;
import static domain.Sugar.ZERO;
import static org.assertj.core.api.Assertions.assertThat;

import domain.Order;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConsoleReportingTest {

  private PrintStream old;
  private ByteArrayOutputStream baos;
  private ConsoleReporting reporting;


  @BeforeEach
  void setUp() {
    reporting = new ConsoleReporting();
    baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
    old = System.out;
    System.setOut(ps);
  }

  @AfterEach
  void tearDown() {
    System.out.flush();
    System.setOut(old);
  }

  @Test
  void coffee_1() {
    reporting.report(new Order(COFFEE, ONE));
    String expected = "Sold: 1 coffees, 0 teas, 0 chocolates, 0 juices. Balance: 0.6\n";
    assertThat(baos.toString()).isEqualTo(expected);
  }

  @Test
  void coffee_1_tea_2() {
    reporting.report(new Order(COFFEE, ONE));
    reporting.report(new Order(TEA, ONE));
    reporting.report(new Order(HOT_TEA, ONE));
    String expected = "Sold: 1 coffees, 0 teas, 0 chocolates, 0 juices. Balance: 0.6\n" +
                      "Sold: 1 coffees, 1 teas, 0 chocolates, 0 juices. Balance: 1.0\n" +
                      "Sold: 1 coffees, 2 teas, 0 chocolates, 0 juices. Balance: 1.4\n";
    assertThat(baos.toString()).isEqualTo(expected);
  }

  @Test
  void coffee_1_tea_2_chocolate_1_juice_2() {
    reporting.report(new Order(COFFEE, ONE));
    reporting.report(new Order(TEA, ONE));
    reporting.report(new Order(HOT_TEA, ONE));
    reporting.report(new Order(CHOCOLATE, ONE));
    reporting.report(new Order(ORANGE_JUICE, ZERO));
    reporting.report(new Order(ORANGE_JUICE, ZERO));
    String expected = "Sold: 1 coffees, 0 teas, 0 chocolates, 0 juices. Balance: 0.6\n" +
                      "Sold: 1 coffees, 1 teas, 0 chocolates, 0 juices. Balance: 1.0\n" +
                      "Sold: 1 coffees, 2 teas, 0 chocolates, 0 juices. Balance: 1.4\n" +
                      "Sold: 1 coffees, 2 teas, 1 chocolates, 0 juices. Balance: 1.9\n" +
                      "Sold: 1 coffees, 2 teas, 1 chocolates, 1 juices. Balance: 2.5\n" +
                      "Sold: 1 coffees, 2 teas, 1 chocolates, 2 juices. Balance: 3.1\n";
    assertThat(baos.toString()).isEqualTo(expected);
  }
}