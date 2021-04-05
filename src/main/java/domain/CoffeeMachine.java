package domain;

public class CoffeeMachine {

  public String makeOrder(Order order) {
    return order.code();
  }

  public String message(String message) {
    return "M:" + message;
  }
}
