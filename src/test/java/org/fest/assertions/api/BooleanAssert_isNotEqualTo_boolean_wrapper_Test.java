/*
 * Created on Oct 22, 2010
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
 * Copyright @2013 the original author or authors.
 */
package org.fest.assertions.api;

import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Tests for {@link BooleanAssert#isNotEqualTo(Boolean)}.
 *
 * @author Yvonne Wang
 */
public class BooleanAssert_isNotEqualTo_boolean_wrapper_Test {
  @Rule
  public ExpectedException thrown = ExpectedException.none();
  private BooleanAssert assertions;
  private Boolean actual;
  private Boolean expected;

  @Before
  public void setUp() {
    actual = new Boolean(true);
    expected = new Boolean(false);
    assertions = new BooleanAssert(actual);
  }

  @Test
  public void should_pass_if_actual_is_not_equal_to_expected() {
    assertions.isNotEqualTo(expected);
  }

  @Test
  public void should_return_this() {
    BooleanAssert returned = assertions.isNotEqualTo(expected);
    assertSame(assertions, returned);
  }

  @Test
  public void should_pass_if_expected_is_null_but_actual_is_not_null() {
    assertions.isNotEqualTo(null);
  }

  @Test
  public void should_pass_if_actual_is_null_but_expected_is_not_null() {
    actual = null;
    assertions = new BooleanAssert(actual);
    assertions.isNotEqualTo(expected);
  }

  @Test
  public void should_fail_if_both_actual_and_expected_are_null() {
    thrown.expect(AssertionError.class);
    actual = null;
    assertions = new BooleanAssert(actual);
    assertions.isNotEqualTo(null);
  }

  @Test
  public void should_fail_if_actual_is_equal_to_expected() {
    thrown.expect(AssertionError.class);
    assertions.isNotEqualTo(actual);
  }
}
