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

/**
 * A mutable person class created using Eclipse IDE.
 */
public class EclipseMutablePerson {
  // NOTES
  // Requires four wizards - getter/setter, constructor, equals/hashCode, toString
  // Generated Javadoc is minimal

  /**
   * The name of the person.
   */
  private String name;
  /**
   * The date of birth.
   */
  private LocalDate birthDate;

  /**
   * 
   */
  public EclipseMutablePerson() {
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the birthDate
   */
  public LocalDate getBirthDate() {
    return birthDate;
  }

  /**
   * @param birthDate the birthDate to set
   */
  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  @Override
  public int hashCode() {
    return Objects.hash(birthDate, name);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof EclipseMutablePerson)) {
      return false;
    }
    EclipseMutablePerson other = (EclipseMutablePerson) obj;
    return Objects.equals(birthDate, other.birthDate) && Objects.equals(name, other.name);
  }

  @Override
  public String toString() {
    return "EclipseMutablePerson [name=" + name + ", birthDate=" + birthDate + "]";
  }

}
