package domain;

import java.math.BigDecimal;

public enum Drink {
  COFFEE("C:", DrinkPrices.COFFEE_PRICE),
  TEA("T:", DrinkPrices.TEA_PRICE),
  CHOCOLATE("H:", DrinkPrices.CHOCOLATE_PRICE);

  private final String code;
  private final Amount price;

  Drink(String code, Amount price) {
    this.code = code;
    this.price = price;
  }

  public String code() {
    return code;
  }
  public Amount price() {
    return price;
  }

  private static class DrinkPrices {
    public static final Amount COFFEE_PRICE = new Amount(new BigDecimal("0.6"));
    public static final Amount TEA_PRICE = new Amount(new BigDecimal("0.4"));
    public static final Amount CHOCOLATE_PRICE = new Amount(new BigDecimal("0.5"));
  }

}
