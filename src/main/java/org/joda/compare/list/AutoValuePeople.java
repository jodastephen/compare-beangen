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

import org.joda.compare.AutoValuePerson;

import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;

@AutoValue
public abstract class AutoValuePeople {
  // NOTES

  /**
   * Creates a builder.
   * 
   * @return the builder
   */
  public static Builder builder() {
    return new AutoValue_AutoValuePeople.Builder();
  }

  /**
   * Gets the friends.
   * 
   * @return the friends
   */
  public abstract List<AutoValuePerson> getFriends();

  /**
   * Gets the tags.
   * 
   * @return the tags
   */
  public abstract ImmutableList<String> getTags();

  @AutoValue.Builder
  public static abstract class Builder {
    /**
     * Sets the friends.
     * 
     * @param friends  the friends
     * @return the builder, for chaining
     */
    public abstract Builder friends(List<AutoValuePerson> friends);

    /**
     * Sets the name of the person.
     * 
     * @param tags  the tags
     * @return the builder, for chaining
     */
    public abstract Builder tags(List<String> tags);

    /**
     * Builds the person.
     * 
     * @return the person
     */
    public abstract AutoValuePeople build();
  }

}
