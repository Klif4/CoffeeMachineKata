package infra;

import domain.Order;
import domain.ports.Reporting;
import java.math.BigDecimal;

public class ConsoleReporting implements Reporting {

  private BigDecimal balance = BigDecimal.ZERO;
  private int coffeeCounter = 0;
  private int teaCounter = 0;
  private int chocolateCounter = 0;
  private int juiceCounter = 0;



  @Override
  public void report(Order order) {
    incrementCounters(order);
    balance = balance.add(order.price().value());
    System.out.println("Sold: "+ coffeeCounter + " coffees, " + teaCounter + " teas, "
                           + chocolateCounter + " chocolates, " + juiceCounter
                           + " juices. Balance: "+ balance);
  }

  private void incrementCounters(Order order) {
    switch (order.drink()) {
      case COFFEE:
      case HOT_COFFEE:
        coffeeCounter++;
        break;
      case TEA:
      case HOT_TEA:
        teaCounter++;
        break;
      case CHOCOLATE:
      case HOT_CHOCOLATE:
        chocolateCounter++;
        break;
      case ORANGE_JUICE:
        juiceCounter++;
        break;
      default:
        break;
    }
  }
}
