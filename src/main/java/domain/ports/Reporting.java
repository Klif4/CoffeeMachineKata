package domain.ports;

import domain.Order;

public interface Reporting {
  void report(Order order);
}
