package org.joda.compare;

import java.util.function.Function;
import org.derive4j.Data;

@Data
public abstract class Derive4jCollaborator
{

  // For now only one kind of collaborator: employees
  interface Cases<X> {
    X Employee(int employeeId);
  }

  public abstract <X> X match(Cases<X> cases);

  @Override
  public abstract int hashCode();
  @Override
  public abstract boolean equals(Object obj);
  @Override
  public abstract String toString();
}
