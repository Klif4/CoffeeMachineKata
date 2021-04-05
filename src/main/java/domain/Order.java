package domain;

public class Order {

  private final Drink drink;
  private final Sugar sugar;

  public Order(Drink drink, Sugar sugar) {
    this.drink = drink;
    this.sugar = sugar;
  }

  public String code() {
    return drink.code() + sugar.sugarsAndStickCode();
  }

  public Amount price() {
    return drink.price();
  }
}
