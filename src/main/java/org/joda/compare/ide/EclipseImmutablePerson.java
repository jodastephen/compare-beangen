/*
 *  Copyright 2016-present Stephen Colebourne
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.joda.compare.ide;

import java.time.LocalDate;

public class EclipseImmutablePerson {
  // NOTES
  // Requires four wizards - getter, constructor, equals/hashCode, toString
  // Javadoc on getter is simple, not derived from field docs

  /**
   * The name of the person.
   */
  private final String name;
  /**
   * The date of birth.
   */
  private final LocalDate birthDate;

  public EclipseImmutablePerson(String name, LocalDate birthDate) {
    super();
    this.name = name;
    this.birthDate = birthDate;
  }

  /**
   * Gets the name.
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the birthDate.
   * @return the birthDate
   */
  public LocalDate getBirthDate() {
    return birthDate;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    EclipseImmutablePerson other = (EclipseImmutablePerson) obj;
    if (birthDate == null) {
      if (other.birthDate != null) {
        return false;
      }
    } else if (!birthDate.equals(other.birthDate)) {
      return false;
    }
    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!name.equals(other.name)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "EclipseImmutablePerson [name=" + name + ", birthDate=" + birthDate + "]";
  }

}
