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
package org.joda.compare.mutable;

import java.time.LocalDate;

import com.fortyoneconcepts.valjogen.annotations.VALJOConfigure;
import com.fortyoneconcepts.valjogen.annotations.VALJOGenerate;
import com.fortyoneconcepts.valjogen.annotations.types.Mutability;

@VALJOGenerate
@VALJOConfigure(mutability = Mutability.Mutable, ensureNotNullEnabled = false)
public interface ValjoMutable {
  // NOTES

  /**
   * Gets the name of the person.
   * 
   * @return the name
   */
  public abstract String getName();

  /**
   * Sets the name of the person.
   * 
   * @param name  the name
   */
  public abstract void setName(String name);

  /**
   * Gets the date of birth.
   * 
   * @return the date of birth
   */
  public abstract LocalDate getBirthDate();

  /**
   * Sets the birth date of the person.
   * 
   * @param birthDate  the birth date
   */
  public abstract void setBirthDate(LocalDate birthDate);

}
