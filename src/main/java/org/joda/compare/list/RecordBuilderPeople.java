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
package org.joda.compare.list;

import java.util.List;

import org.joda.compare.RecordBuilderPerson;

import io.soabase.recordbuilder.core.RecordBuilderFull;

/**
 * Sample record generated using RecordBuilder.
 */
@RecordBuilderFull
public record RecordBuilderPeople(List<RecordBuilderPerson> friends, List<String> tags)
    implements RecordBuilderPeopleBuilder.With {
  // NOTES
  // Requires setting up annotation processing
  // Processor generates source code
  // Implementing With interface generates withers
  // Builder uses .with() instead of .toBuilder()

  //  public RecordBuilderPeople {
  //    friends = List.copyOf(friends);
  //    tags = List.copyOf(tags);
  //  }

}
