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

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class AutoValuePersonWithBuilder {
  // NOTES
  // Requires setting up annotation processing
  // Have to write Javadoc on getter/setter
  // Only immutable

  /**
   * Creates a builder.
   * 
   * @return the builder
   */
  public static Builder builder() {
    return new AutoValue_AutoValuePersonWithBuilder.Builder();
  }

  /**
   * Gets the name of the person.
   * 
   * @return the name
   */
  public abstract String getName();

  /**
   * Gets the date of birth.
   * 
   * @return the date of birth
   */
  public abstract LocalDate getBirthDate();

  /**
   * Converts this bean to a builder.
   * 
   * @return the builder
   */
  public abstract Builder toBuilder();

  @AutoValue.Builder
  public static abstract class Builder {
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
    public abstract AutoValuePersonWithBuilder build();
  }

}
