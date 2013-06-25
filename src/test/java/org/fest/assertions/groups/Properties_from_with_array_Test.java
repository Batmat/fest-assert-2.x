/*
 * Created on Feb 22, 2011
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright @2011-2013 the original author or authors.
 */
package org.fest.assertions.groups;

import static junit.framework.Assert.assertSame;

import static org.fest.util.Arrays.array;

import java.util.ArrayList;
import java.util.List;

import org.fest.assertions.test.Employee;
import org.fest.assertions.test.Name;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests for {@link Properties#from(Object[])}.
 *
 * @author Yvonne Wang
 * @author Mikhail Mazursky
 */
public class Properties_from_with_array_Test {

  private static Employee yoda;
  private static Object[] employees;

  @BeforeClass
  public static void setUpOnce() {
    yoda = new Employee(6000L, new Name("Yoda"), 800);
    employees = array(yoda);
  }

  // private PropertySupport propertySupport;
  private String propertyName;
  private Properties<Long> properties;

  @Before
  public void setUp() {
    // propertySupport = mock(PropertySupport.class);
    propertyName = "id";
    properties = new Properties<Long>(propertyName, Long.class);
    // properties.propertySupport = propertySupport;
  }

  @Test
  public void should_return_values_of_property() {
    List<Long> ids = new ArrayList<Long>();
    ids.add(yoda.getId());
    // when(propertySupport.propertyValues(propertyName, Long.class, wrap(employees))).thenReturn(ids);
    assertSame(ids, properties.from(employees));
  }
}
