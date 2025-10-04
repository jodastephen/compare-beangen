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
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.joda.compare.RecordBuilderPersonBuilder.RecordBuilderPerson;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.joda.compare.ide.EclipseImmutablePerson;
import org.joda.compare.ide.EclipseMutablePerson;
import org.joda.compare.ide.IntelliJImmutablePerson;
import org.joda.compare.ide.IntelliJMutablePerson;
import org.joda.compare.list.RecordBuilderPeople;
import org.joda.compare.list.RecordBuilderPeopleBuilder;
import org.joda.compare.mutable.JodaBeansMutable;
import org.joda.compare.mutable.LombokMutable;
import org.joda.compare.mutable.ModifiableImmOrgMutable;
import org.junit.jupiter.api.Test;

class PersonTest {

  private static final String NAME = "Stephen";
  private static final LocalDate DATE = LocalDate.of(2016, 9, 22);

  //-------------------------------------------------------------------------
  @Test
  void testRecord() {
    var test = new RecordPerson(NAME, DATE);
    assertThat(test.name()).isEqualTo(NAME);
    assertThat(test.birthDate()).isEqualTo(DATE);
    assertThat(test.toString()).isEqualTo("RecordPerson[name=Stephen, birthDate=2016-09-22]");
  }

  //-------------------------------------------------------------------------
  //-------------------------------------------------------------------------
  @Test
  void testRecordBuilder() {
    var test = RecordBuilderPersonBuilder.builder()
        .name(NAME)
        .birthDate(DATE)
        .build();
    assertThat(test.name()).isEqualTo(NAME);
    assertThat(test.birthDate()).isEqualTo(DATE);
    assertThat(test.toString()).isEqualTo("RecordBuilderPerson[name=Stephen, birthDate=2016-09-22]");
  }

  @Test
  void testRecordBuilderFactoryStaticImport() {
    // this is a static factory method with an unusual UpperCamelCase name
    // that has then been statically imported. It looks a bit weird in Java IMO
    var test = RecordBuilderPerson(NAME, DATE);
    assertThat(test.name()).isEqualTo(NAME);
    assertThat(test.birthDate()).isEqualTo(DATE);
    assertThat(test.toString()).isEqualTo("RecordBuilderPerson[name=Stephen, birthDate=2016-09-22]");
  }

  @Test
  void testRecordBuilderWith() {
    var test = new RecordBuilderPerson(NAME, DATE);
    test = test.withName(NAME).withBirthDate(DATE);
    test = test.with()
        .name(NAME)
        .birthDate(DATE)
        .build();
    assertThat(test.toString()).isEqualTo("RecordBuilderPerson[name=Stephen, birthDate=2016-09-22]");

    test = test.withName(NAME);

    test = test.with(builder -> {
      builder.name(NAME);
    });
  }

  @Test
  void testRecordPeopleBuilderMutability() {
    var person = new RecordBuilderPerson(NAME, DATE);
    var friends = new ArrayList<RecordBuilderPerson>();
    friends.add(person);
    var tags = List.<String>of();
    var test = new RecordBuilderPeople(friends, tags);
    test.friends().add(person);
    assertThat(test.friends()).hasSize(2); // the list via the record constructor is mutable (bad!)

    var test2 = RecordBuilderPeopleBuilder.builder().addFriends(friends).addTags(tags).build();
    assertThatExceptionOfType(UnsupportedOperationException.class)
        .isThrownBy(() -> test2.friends().add(person)); // the list via the builder is immutable (good)
  }

  //-------------------------------------------------------------------------
  //-------------------------------------------------------------------------
  @Test
  void testEclipseMutable() {
    var test = new EclipseMutablePerson();
    test.setName(NAME);
    test.setBirthDate(DATE);
    assertThat(test.getName()).isEqualTo(NAME);
    assertThat(test.getBirthDate()).isEqualTo(DATE);
    assertThat(test.toString()).isEqualTo("EclipseMutablePerson [name=Stephen, birthDate=2016-09-22]");
  }

  @Test
  void testEclipseImmutable() {
    var test = new EclipseImmutablePerson(NAME, DATE);
    assertThat(test.getName()).isEqualTo(NAME);
    assertThat(test.getBirthDate()).isEqualTo(DATE);
    assertThat(test.toString()).isEqualTo("EclipseImmutablePerson [name=Stephen, birthDate=2016-09-22]");
  }

  //-------------------------------------------------------------------------
  @Test
  void testIntelliJMutable() {
    var test = new IntelliJMutablePerson();
    test.setName(NAME);
    test.setBirthDate(DATE);
    assertThat(test.getName()).isEqualTo(NAME);
    assertThat(test.getBirthDate()).isEqualTo(DATE);
    assertThat(test.toString()).isEqualTo("IntelliJMutablePerson{name='Stephen', birthDate=2016-09-22}");
  }

  @Test
  void testIntelliJImmutable() {
    var test = new IntelliJImmutablePerson(NAME, DATE);
    assertThat(test.getName()).isEqualTo(NAME);
    assertThat(test.getBirthDate()).isEqualTo(DATE);
    assertThat(test.toString()).isEqualTo("IntelliJImmutablePerson{name='Stephen', birthDate=2016-09-22}");
  }

  //-------------------------------------------------------------------------
  //-------------------------------------------------------------------------
  //-------------------------------------------------------------------------
  @Test
  void testAutoValuePerson() {
    var test = AutoValuePerson.of(NAME, DATE);
    assertThat(test.getName()).isEqualTo(NAME);
    assertThat(test.getBirthDate()).isEqualTo(DATE);
    assertThat(test.toString()).isEqualTo("AutoValuePerson{name=Stephen, birthDate=2016-09-22}");
  }

  @Test
  void testAutoValuePersonWithBuilder() {
    var test = AutoValuePersonWithBuilder.builder().name(NAME).birthDate(DATE).build();
    assertThat(test.getName()).isEqualTo(NAME);
    assertThat(test.getBirthDate()).isEqualTo(DATE);
    assertThat(test.toString()).isEqualTo("AutoValuePersonWithBuilder{name=Stephen, birthDate=2016-09-22}");
  }

  //-------------------------------------------------------------------------
  @Test
  void testImmOrgPerson() {
    var test = ImmutableImmOrgPerson.of(NAME, DATE);
    assertThat(test.getName()).isEqualTo(NAME);
    assertThat(test.getBirthDate()).isEqualTo(DATE);
    assertThat(test.toString()).isEqualTo("ImmOrgPerson{name=Stephen, birthDate=2016-09-22}");

    test = ImmutableImmOrgPerson.builder()
        .from(test)
        .name(NAME)
        .build();
    
    test = test.withName(NAME);
  }

  @Test
  void testImmOrgPersonUsingBuilder() {
    var test = ImmutableImmOrgPerson.builder().name(NAME).birthDate(DATE).build();
    assertThat(test.getName()).isEqualTo(NAME);
    assertThat(test.getBirthDate()).isEqualTo(DATE);
    assertThat(test.toString()).isEqualTo("ImmOrgPerson{name=Stephen, birthDate=2016-09-22}");
  }

  //-------------------------------------------------------------------------
  @Test
  void testImmOrgPackagePerson() {
    var test = ImmOrgPackagePerson.of(NAME, DATE);
    assertThat(test.getName()).isEqualTo(NAME);
    assertThat(test.getBirthDate()).isEqualTo(DATE);
    assertThat(test.toString()).isEqualTo("ImmOrgPackagePerson{name=Stephen, birthDate=2016-09-22}");
  }

  @Test
  void testImmOrgPackagePersonUsingBuilder() {
    var test = ImmOrgPackagePerson.builder().name(NAME).birthDate(DATE).build();
    assertThat(test.getName()).isEqualTo(NAME);
    assertThat(test.getBirthDate()).isEqualTo(DATE);
    assertThat(test.toString()).isEqualTo("ImmOrgPackagePerson{name=Stephen, birthDate=2016-09-22}");
  }

  //-------------------------------------------------------------------------
  @Test
  void testMagicPerson() {
    var test = new MagicPerson();
    test.setName(NAME);
    test.setBirthDate(DATE);
    assertThat(test.getName()).isEqualTo(NAME);
    assertThat(test.getBirthDate()).isEqualTo(DATE);
    assertThat(test.toString()).isEqualTo("MagicPerson[name=Stephen, birthDate=2016-09-22]");
  }

  //-------------------------------------------------------------------------
  @Test
  void testLombokPerson() {
    var test = LombokPerson.of(NAME, DATE);
    assertThat(test.getName()).isEqualTo(NAME);
    assertThat(test.getBirthDate()).isEqualTo(DATE);
    assertThat(test.toString()).isEqualTo("LombokPerson(name=Stephen, birthDate=2016-09-22)");
  }

  @Test
  void testLombokPersonWithBuilder() {
    var test = LombokPersonWithBuilder.builder().name(NAME).birthDate(DATE).build();
    assertThat(test.getName()).isEqualTo(NAME);
    assertThat(test.getBirthDate()).isEqualTo(DATE);
    assertThat(test.toString()).isEqualTo("LombokPersonWithBuilder(name=Stephen, birthDate=2016-09-22)");
  }

  //-------------------------------------------------------------------------
  @Test
  void testJodaBeansPerson() {
    var test = JodaBeansPerson.of(NAME, DATE);
    assertThat(test.getName()).isEqualTo(NAME);
    assertThat(test.getBirthDate()).hasValue(DATE);
    assertThat(test.toString()).isEqualTo("JodaBeansPerson{name=Stephen, birthDate=2016-09-22}");
  }

  @Test
  void testJodaBeansPersonUsingBuilder() {
    var test = JodaBeansPerson.builder().name(NAME).birthDate(DATE).build();
    assertThat(test.getName()).isEqualTo(NAME);
    assertThat(test.getBirthDate()).hasValue(DATE);
    assertThat(test.toString()).isEqualTo("JodaBeansPerson{name=Stephen, birthDate=2016-09-22}");
  }

  //-------------------------------------------------------------------------
  //-------------------------------------------------------------------------
  //-------------------------------------------------------------------------
  @Test
  void testImmOrgMutable() {
    var test = ModifiableImmOrgMutable.create();
    test.setName(NAME);
    test.setBirthDate(DATE);
    assertThat(test.getName()).isEqualTo(NAME);
    assertThat(test.getBirthDate()).isEqualTo(DATE);
    assertThat(test.toString()).isEqualTo("ModifiableImmOrgMutable{name=Stephen, birthDate=2016-09-22}");
  }

  @Test
  void testLombokMutable() {
    var test = new LombokMutable();
    test.setName(NAME);
    test.setBirthDate(DATE);
    assertThat(test.getName()).isEqualTo(NAME);
    assertThat(test.getBirthDate()).isEqualTo(DATE);
    assertThat(test.toString()).isEqualTo("LombokMutable(name=Stephen, birthDate=2016-09-22)");
  }

  @Test
  void testJodaBeansMutable() {
    var test = new JodaBeansMutable();
    test.setName(NAME);
    test.setBirthDate(DATE);
    assertThat(test.getName()).isEqualTo(NAME);
    assertThat(test.getBirthDate()).isEqualTo(DATE);
    assertThat(test.toString()).isEqualTo("JodaBeansMutable{name=Stephen, birthDate=2016-09-22}");
  }

}
