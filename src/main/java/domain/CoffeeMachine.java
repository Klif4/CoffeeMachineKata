package domain;

import domain.ports.Reporting;

public class CoffeeMachine {

  private final Reporting reporting;

  public CoffeeMachine(Reporting reporting) {
    this.reporting = reporting;
  }

  public String makeOrder(Order order, Amount customerMoney) {
    if (customerMoney.isEnoughFor(order.price())) {
      reporting.report(order);
      return order.code();
    }
    return message("Missing " + customerMoney.difference(order.price()).value());
  }

  public String message(String message) {
    return "M:" + message;
  }
}
