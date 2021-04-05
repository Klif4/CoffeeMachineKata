package domain;

import static domain.Drink.ORANGE_JUICE;
import static domain.Sugar.ZERO;

public class Order {

  private final Drink drink;
  private final Sugar sugar;

  public Order(Drink drink, Sugar sugar) {
    this.drink = drink;
    this.sugar = drink.equals(ORANGE_JUICE) ? ZERO : sugar;
  }

  public Drink drink() {
    return drink;
  }

  public String code() {
    return drink.code() + sugar.sugarsAndStickCode();
  }

  public Amount price() {
    return drink.price();
  }
}
