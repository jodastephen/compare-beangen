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
package org.joda.compare;

import java.time.LocalDate;

import org.immutables.value.Value;
import org.immutables.value.Value.Style.ImplementationVisibility;

@Value.Immutable
@Value.Style(visibility = ImplementationVisibility.PACKAGE)
public interface ImmOrgPackagePerson {
  // NOTES
  // Requires setting up annotation processing
  // Have to write Javadoc on getter
  // Lots of configuration options

  /**
   * Creates an instance.
   * 
   * @param name  the name
   * @param birthDate  the date of birth
   * @return the person
   */
  public static ImmOrgPackagePerson of(String name, LocalDate birthDate) {
    return ImmutableImmOrgPackagePerson.of(name, birthDate);
  }

  /**
   * Creates an instance.
   * 
   * @param name  the name
   * @param birthDate  the date of birth
   * @return the person
   */
  public static ImmOrgPackagePerson.Builder builder() {
    return ImmutableImmOrgPackagePerson.builder();
  }

  /**
   * The name of the person.
   * 
   * @return the name
   */
  @Value.Parameter
  public abstract String getName();

  /**
   * The date of birth.
   * 
   * @return the date of birth
   */
  @Value.Parameter
  public abstract LocalDate getBirthDate();

  public interface Builder {

    /**
     * Sets the name of the person.
     * 
     * @param value  the name
     * @return the builder, for chaining
     */
    public abstract Builder name(String value);

    /**
     * Sets the name of the person.
     * 
     * @param value  the date of birth
     * @return the builder, for chaining
     */
    public abstract Builder birthDate(LocalDate value);

    /**
     * Builds the person.
     * 
     * @return the person
     */
    public abstract ImmOrgPackagePerson build();
    
  }

}
