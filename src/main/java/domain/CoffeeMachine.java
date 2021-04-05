package domain;

public class CoffeeMachine {

  public String makeOrder(Order order, Amount customerMoney) {
    return customerMoney.isEnoughFor(order.price()) ?
        order.code() :
        message("Missing " + customerMoney.difference(order.price()).value());
  }

  public String message(String message) {
    return "M:" + message;
  }
}
