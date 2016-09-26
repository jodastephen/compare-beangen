package org.joda.compare;

import java.util.List;
import org.derive4j.Data;

import static org.joda.compare.Derive4jPersons.cases;

@Data
public abstract class Derive4jPerson {

  // A person can be one of those:
  interface Cases<X> {
    X Client(Derive4jClientInfo client);

    X Collaborator(Derive4jCollaborator collaborator);

    X ThirdParty(String thirdPartyDesignation);
  }

  // Derive4J rely on the visitor pattern:
  public abstract <X> X match(Cases<X> cases);

  @Override
  public abstract int hashCode();
  @Override
  public abstract boolean equals(Object obj);
  @Override
  public abstract String toString();

  /**
   * Demonstration of derive4j pattern matching capability:
   */
  public static int businessMeetingRiskLevel(List<Derive4jPerson> attendees) {
    // each client incurs +2 risk points, third party +1, each collaborator present lowers the risk by 2.
    return attendees.stream().mapToInt(
        cases().
            Client(+2).
            Collaborator(-2).
            ThirdParty(+1)::apply
    ).sum();
  }
}
