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

import static org.joda.compare.Derive4jClientInfos.ClientInfo;
import static org.joda.compare.Derive4jClientInfos.modBirthDate;
import static org.joda.compare.Derive4jPersons.Client;
import static org.joda.compare.Derive4jPersons.getClient;
import static org.joda.compare.Derive4jPersons.modClient;
import static org.testng.Assert.assertEquals;

import java.time.LocalDate;

import java.util.Optional;
import org.joda.compare.ide.EclipseImmutablePerson;
import org.joda.compare.ide.EclipseMutablePerson;
import org.joda.compare.ide.IntelliJImmutablePerson;
import org.joda.compare.ide.IntelliJMutablePerson;
import org.joda.compare.mutable.ImmOrgMutable;
import org.joda.compare.mutable.JodaBeansMutable;
import org.joda.compare.mutable.LombokMutable;
import org.joda.compare.mutable.ModifiableImmOrgMutable;
import org.joda.compare.mutable.ValjoMutable;
import org.joda.compare.mutable.ValjoMutableImpl;
import org.testng.annotations.Test;

@Test
public class PersonTest {

  private static final String NAME = "Stephen";
  private static final LocalDate DATE = LocalDate.of(2016, 9, 22);

  //-------------------------------------------------------------------------
  public void testEclipseMutable() {
    EclipseMutablePerson test = new EclipseMutablePerson(NAME, DATE);
    assertEquals(test.getName(), NAME);
    assertEquals(test.getBirthDate(), DATE);
    assertEquals(test.toString(), "EclipseMutablePerson [name=Stephen, birthDate=2016-09-22]");
  }

  public void testEclipseImmutable() {
    EclipseImmutablePerson test = new EclipseImmutablePerson(NAME, DATE);
    assertEquals(test.getName(), NAME);
    assertEquals(test.getBirthDate(), DATE);
    assertEquals(test.toString(), "EclipseImmutablePerson [name=Stephen, birthDate=2016-09-22]");
  }

  //-------------------------------------------------------------------------
  public void testIntelliJMutable() {
    IntelliJMutablePerson test = new IntelliJMutablePerson(NAME, DATE);
    assertEquals(test.getName(), NAME);
    assertEquals(test.getBirthDate(), DATE);
    assertEquals(test.toString(), "IntelliJMutablePerson [name='Stephen', birthDate='2016-09-22']");
  }

  public void testIntelliJImmutable() {
    IntelliJImmutablePerson test = new IntelliJImmutablePerson(NAME, DATE);
    assertEquals(test.getName(), NAME);
    assertEquals(test.getBirthDate(), DATE);
    assertEquals(test.toString(), "IntelliJImmutablePerson [name='Stephen', birthDate='2016-09-22']");
  }

  //-------------------------------------------------------------------------
  //-------------------------------------------------------------------------
  //-------------------------------------------------------------------------
  public void testAutoValuePerson() {
    AutoValuePerson test = AutoValuePerson.of(NAME, DATE);
    assertEquals(test.getName(), NAME);
    assertEquals(test.getBirthDate(), DATE);
    assertEquals(test.toString(), "AutoValuePerson{name=Stephen, birthDate=2016-09-22}");
  }

  public void testAutoValuePersonWithBuilder() {
    AutoValuePersonWithBuilder test = AutoValuePersonWithBuilder.builder().name(NAME).birthDate(DATE).build();
    assertEquals(test.getName(), NAME);
    assertEquals(test.getBirthDate(), DATE);
    assertEquals(test.toString(), "AutoValuePersonWithBuilder{name=Stephen, birthDate=2016-09-22}");
  }

  //-------------------------------------------------------------------------
  public void testImmOrgPerson() {
    ImmOrgPerson test = ImmutableImmOrgPerson.of(NAME, DATE);
    assertEquals(test.getName(), NAME);
    assertEquals(test.getBirthDate(), DATE);
    assertEquals(test.toString(), "ImmOrgPerson{name=Stephen, birthDate=2016-09-22}");
  }

  public void testImmOrgPersonUsingBuilder() {
    ImmOrgPerson test = ImmutableImmOrgPerson.builder().name(NAME).birthDate(DATE).build();
    assertEquals(test.getName(), NAME);
    assertEquals(test.getBirthDate(), DATE);
    assertEquals(test.toString(), "ImmOrgPerson{name=Stephen, birthDate=2016-09-22}");
  }

  //-------------------------------------------------------------------------
  public void testImmOrgSuperPerson() {
    ImmOrgSuperPerson test = new ImmOrgSuperPerson.Builder().name(NAME).birthDate(DATE).build();
    assertEquals(test.getName(), NAME);
    assertEquals(test.getBirthDate(), DATE);
    assertEquals(test.toString(), "ImmOrgSuperPerson{name=Stephen, birthDate=2016-09-22}");
    ImmOrgSuperPerson test2 = test.withName("Changed");
    assertEquals(test2.getName(), "Changed");
    assertEquals(test2.getBirthDate(), DATE);
  }

  //-------------------------------------------------------------------------
  public void testImmOrgPackagePerson() {
    ImmOrgPackagePerson test = ImmOrgPackagePerson.of(NAME, DATE);
    assertEquals(test.getName(), NAME);
    assertEquals(test.getBirthDate(), DATE);
    assertEquals(test.toString(), "ImmOrgPackagePerson{name=Stephen, birthDate=2016-09-22}");
  }

  public void testImmOrgPackagePersonUsingBuilder() {
    ImmOrgPackagePerson test = ImmOrgPackagePerson.builder().name(NAME).birthDate(DATE).build();
    assertEquals(test.getName(), NAME);
    assertEquals(test.getBirthDate(), DATE);
    assertEquals(test.toString(), "ImmOrgPackagePerson{name=Stephen, birthDate=2016-09-22}");
  }

  //-------------------------------------------------------------------------
  public void testImmOrgPrivatePersonUsingBuilder() {
    ImmOrgPrivatePerson test = new ImmOrgPrivatePersonBuilder().name(NAME).birthDate(DATE).build();
    assertEquals(test.getName(), NAME);
    assertEquals(test.getBirthDate(), DATE);
    assertEquals(test.toString(), "ImmOrgPrivatePerson{name=Stephen, birthDate=2016-09-22}");
  }

  //-------------------------------------------------------------------------
  public void testLombokPerson() {
    LombokPerson test = LombokPerson.of(NAME, DATE);
    assertEquals(test.getName(), NAME);
    assertEquals(test.getBirthDate(), DATE);
    assertEquals(test.toString(), "LombokPerson(name=Stephen, birthDate=2016-09-22)");
  }

  public void testLombokPersonWithBuilder() {
    LombokPersonWithBuilder test = LombokPersonWithBuilder.builder().name(NAME).birthDate(DATE).build();
    assertEquals(test.getName(), NAME);
    assertEquals(test.getBirthDate(), DATE);
    assertEquals(test.toString(), "LombokPersonWithBuilder(name=Stephen, birthDate=2016-09-22)");
  }

  //-------------------------------------------------------------------------
  public void testPojomaticPerson() {
    PojomaticPerson test = new PojomaticPerson(NAME, DATE);
    assertEquals(test.getName(), NAME);
    assertEquals(test.getBirthDate(), DATE);
    assertEquals(test.toString(), "PojomaticPerson{name: {Stephen}, birthDate: {2016-09-22}}");
  }

  //-------------------------------------------------------------------------
  public void testValjoPerson() {
    ValjoPerson test = ValjoPersonImpl.valueOf(NAME, DATE);
    assertEquals(test.getName(), NAME);
    assertEquals(test.getBirthDate(), DATE);
    assertEquals(test.toString(), "ValjoPersonImpl [name=Stephen, birthDate=2016-09-22]");
  }

  //-------------------------------------------------------------------------
  public void testJodaBeansPerson() {
    JodaBeansPerson test = JodaBeansPerson.of(NAME, DATE);
    assertEquals(test.getName(), NAME);
    assertEquals(test.getBirthDate(), DATE);
    assertEquals(test.toString(), "JodaBeansPerson{name=Stephen, birthDate=2016-09-22}");
  }

  public void testJodaBeansPersonUsingBuilder() {
    JodaBeansPerson test = JodaBeansPerson.builder().name(NAME).birthDate(DATE).build();
    assertEquals(test.getName(), NAME);
    assertEquals(test.getBirthDate(), DATE);
    assertEquals(test.toString(), "JodaBeansPerson{name=Stephen, birthDate=2016-09-22}");
  }

  //-------------------------------------------------------------------------
  public void testDerive4jPerson() {
    Derive4jPerson person = Client(ClientInfo(NAME, DATE));
    Optional<Derive4jClientInfo> maybeClient = getClient(person);
    assertEquals(maybeClient.map(Derive4jClientInfos::getName), Optional.of(NAME));
    assertEquals(maybeClient.map(Derive4jClientInfos::getBirthDate), Optional.of(DATE));
    assertEquals(person.toString(), "Client(ClientInfo(Stephen, 2016-09-22))");
    // let's modify birth-date, as it has a off by one error:
    Derive4jPerson fixedBirthDatePerson =
        modClient(modBirthDate(birthDate -> birthDate.plusDays(1))).apply(person);
    assertEquals(fixedBirthDatePerson.toString(), "Client(ClientInfo(Stephen, 2016-09-23))");
  }

  //-------------------------------------------------------------------------
  //-------------------------------------------------------------------------
  //-------------------------------------------------------------------------
  public void testImmOrgMutable() {
    ImmOrgMutable test = ModifiableImmOrgMutable.create();
    test.setName(NAME);
    test.setBirthDate(DATE);
    assertEquals(test.getName(), NAME);
    assertEquals(test.getBirthDate(), DATE);
    assertEquals(test.toString(), "ModifiableImmOrgMutable{name=Stephen, birthDate=2016-09-22}");
  }

  public void testLombokMutable() {
    LombokMutable test = new LombokMutable();
    test.setName(NAME);
    test.setBirthDate(DATE);
    assertEquals(test.getName(), NAME);
    assertEquals(test.getBirthDate(), DATE);
    assertEquals(test.toString(), "LombokMutable(name=Stephen, birthDate=2016-09-22)");
  }

  public void testValjoMutable() {
    ValjoMutable test = ValjoMutableImpl.valueOf(NAME, DATE);
    assertEquals(test.getName(), NAME);
    assertEquals(test.getBirthDate(), DATE);
    assertEquals(test.toString(), "ValjoMutableImpl [name=Stephen, birthDate=2016-09-22]");
  }

  public void testJodaBeansMutable() {
    JodaBeansMutable test = new JodaBeansMutable();
    test.setName(NAME);
    test.setBirthDate(DATE);
    assertEquals(test.getName(), NAME);
    assertEquals(test.getBirthDate(), DATE);
    assertEquals(test.toString(), "JodaBeansMutable{name=Stephen, birthDate=2016-09-22}");
  }

}
