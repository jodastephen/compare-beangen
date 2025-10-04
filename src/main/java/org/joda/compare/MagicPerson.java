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

import dev.mccue.magicbean.MagicBean;

/**
 * Sample bean generated using <a href="https://github.com/bowbahdoe/magic-bean">MagicBean</a>.
 */
@MagicBean(allArgsStaticFactory = true, toString_ = true, equalsAndHashCode = true)
public final class MagicPerson extends MagicPersonBeanOps {
  // NOTES
  // Requires setting up annotation processing
  // Processor generates source code
  // Only mutable
  // Does not refresh in Eclipse, needs a command line build
  // Does not validate nulls

  /**
   * The name of the person.
   */
  String name;

  /**
   * The date of birth.
   */
  LocalDate birthDate;

}
