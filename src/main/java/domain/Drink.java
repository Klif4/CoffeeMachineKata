package domain;

import java.math.BigDecimal;

public enum Drink {
  COFFEE("C:", DrinkPrices.COFFEE_PRICE),
  TEA("T:", DrinkPrices.TEA_PRICE),
  CHOCOLATE("H:", DrinkPrices.CHOCOLATE_PRICE),
  HOT_COFFEE("Ch:", DrinkPrices.COFFEE_PRICE),
  HOT_TEA("Th:", DrinkPrices.TEA_PRICE),
  HOT_CHOCOLATE("Hh:", DrinkPrices.CHOCOLATE_PRICE),
  ORANGE_JUICE("O:", DrinkPrices.ORANGE_JUICE_PRICE);

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
    public static final Amount ORANGE_JUICE_PRICE = new Amount(new BigDecimal("0.6"));
  }

}
