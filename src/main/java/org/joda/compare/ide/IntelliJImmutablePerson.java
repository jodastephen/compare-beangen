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
import java.util.Objects;

public class IntelliJImmutablePerson {
  // NOTES
  // Requires four dialogs - getter, constructor, equals/hashCode, toString
  // Generates more compact code than Eclipse

  /**
   * The name of the person.
   */
  private final String name;
  /**
   * The date of birth.
   */
  private final LocalDate birthDate;

  public IntelliJImmutablePerson(String name, LocalDate birthDate) {
    this.name = name;
    this.birthDate = birthDate;
  }

  public String getName() {
    return name;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IntelliJImmutablePerson that = (IntelliJImmutablePerson) o;
    return Objects.equals(name, that.name) && Objects.equals(birthDate, that.birthDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, birthDate);
  }

  @Override
  public String toString() {
    return "IntelliJImmutablePerson [" + "name='" + name + "'" + ", birthDate='" + birthDate + "'" + "]";
  }
}
