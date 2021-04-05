package domain;

public enum Sugar {
  ZERO(":"), ONE("1:0"), TWO("2:0");

  private final String sugarsAndStickCode;

  Sugar(String sugarsAndStickCode) {
    this.sugarsAndStickCode = sugarsAndStickCode;
  }

  public String sugarsAndStickCode() {
    return sugarsAndStickCode;
  }
}
