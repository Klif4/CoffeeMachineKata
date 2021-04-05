package domain;

public class CoffeeMachine {

  public String order(Drink drink, Sugar sugar) {
    return drink.code() + sugar.sugarsAndStickCode();
  }

  public String message(String message) {
    return "M:" + message;
  }
}
