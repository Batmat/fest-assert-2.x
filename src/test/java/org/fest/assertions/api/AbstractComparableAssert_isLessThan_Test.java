/*
 * Created on Oct 21, 2010
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
 * Copyright @2010-2013 the original author or authors.
 */
package org.fest.assertions.api;

import org.fest.test.ExpectedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Tests for {@link AbstractComparableAssert#isLessThan(Comparable)}.
 *
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class AbstractComparableAssert_isLessThan_Test {
  @Rule
  public ExpectedException thrown = ExpectedException.none();
  private final Integer actual = new Integer(6);
  private final Integer other = new Integer(8);
  private ConcreteComparableAssert assertions;

  @Before
  public void setUp() {
    assertions = new ConcreteComparableAssert(actual);
  }

  @Test
  public void should_pass_if_actual_is_less_than_other() {
    assertions.isLessThan(other);
  }

  @Test
  public void should_fail_if_actual_is_greater_than_other() {
    thrown.expect(AssertionError.class);
    assertions.isLessThan(new Integer(2));
  }

  @Test
  public void should_fail_if_actual_is_equal_to_other() {
    thrown.expect(AssertionError.class);
    assertions.isLessThan(actual);
  }

  @Test
  public void should_throw_error_if_actual_is_null() {
    assertions = new ConcreteComparableAssert(null);
    thrown.expect(AssertionError.class);
    assertions.isLessThan(other);
  }
}
