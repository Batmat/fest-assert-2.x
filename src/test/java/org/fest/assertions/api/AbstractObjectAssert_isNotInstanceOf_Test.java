/*
 * Created on Jun 3, 2012
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
 * Copyright @2012-2013 the original author or authors.
 */
package org.fest.assertions.api;

import org.fest.test.ExpectedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Tests for {@link AbstractObjectAssert#isNotInstanceOf(Class)}.
 *
 * @author Nicolas François
 * @author Yvonne Wang
 */
public class AbstractObjectAssert_isNotInstanceOf_Test {
  @Rule
  public ExpectedException thrown = ExpectedException.none();
  private final Object actual = "Yoda";
  private ConcreteObjectAssert assertions;

  @Before
  public void setUp() {
    assertions = new ConcreteObjectAssert(actual);
  }

  @Test
  public void should_pass_if_actual_is_not_instance_of_String_class() {
    assertions.isNotInstanceOf(Integer.class);
  }

  @Test
  public void should_fail_if_actual_is_instance_of_String_class() {
    thrown.expect(AssertionError.class);
    assertions.isNotInstanceOf(String.class);
  }

  @Test
  public void should_throw_error_if_given_type_is_null() {
    thrown.expect(NullPointerException.class);
    assertions.isNotInstanceOf(null);
  }
}
