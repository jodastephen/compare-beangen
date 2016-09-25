package org.joda.compare;

import java.time.LocalDate;
import org.derive4j.Data;

@Data
public abstract class Derive4jClientInfo {

  interface Cases<X> {
    X ClientInfo(String name, LocalDate birthDate);
  }

  public abstract <X> X match(Cases<X> cases);

  @Override
  public abstract int hashCode();
  @Override
  public abstract boolean equals(Object obj);
  @Override
  public abstract String toString();

}
