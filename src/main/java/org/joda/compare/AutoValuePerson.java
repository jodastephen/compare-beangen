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
public abstract class AutoValuePerson {
  // NOTES
  // Requires setting up annotation processing
  // Have to write Javadoc on getter/setter
  // Only immutable

  /**
   * Creates an instance.
   * 
   * @param name  the name
   * @param birthDate  the date of birth
   * @return the person
   */
  public static AutoValuePerson of(String name, LocalDate birthDate) {
    return new AutoValue_AutoValuePerson(name, birthDate);
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

}
