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

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.joda.beans.ser.JodaBeanSer;
import org.junit.jupiter.api.Test;

class JodaBeansSerTest {

  private static final String NAME = "Stephen";
  private static final LocalDate DATE = LocalDate.of(2016, 9, 22);

  //-------------------------------------------------------------------------
  @Test
  void testJodaBeansPerson() {
    var test = JodaBeansPerson.of(NAME, DATE);
    var json = JodaBeanSer.PRETTY.jsonWriter().write(test);
    System.out.println(json);
    assertThat(json).isEqualTo("""
        {
         "@bean": "org.joda.compare.JodaBeansPerson",
         "name": "Stephen",
         "birthDate": "2016-09-22"
        }
        """);
  }

}
