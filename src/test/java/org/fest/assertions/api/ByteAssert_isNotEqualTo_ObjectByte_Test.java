/*
 *
 *  * Created on Dec 16, 2010
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 *  * License. You may obtain a copy of the License at
 *  *
 *  * http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS"
 *  * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language
 *  * governing permissions and limitations under the License.
 *  *
 *  * Copyright @2013 the original author or authors.
 *
 */
package org.fest.assertions.api;

import org.fest.test.ExpectedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.fest.test.ExpectedException.none;
import static org.junit.Assert.assertSame;

/**
 * Tests for <code>{@link org.fest.assertions.api.ByteAssert#isNotEqualTo(Comparable)}</code>.
 *
 * @author Yvonne Wang
 */
public class ByteAssert_isNotEqualTo_ObjectByte_Test {
  @Rule
  public ExpectedException thrown = none();
  private ByteAssert assertions;
  private Byte actual = 8;
  private Byte expected = 6;

  @Before
  public void setUp() {
    assertions = new ByteAssert(actual);
  }

  @Test
  public void should_pass_if_actual_is_not_equal_to_expected() {
    assertions.isNotEqualTo(expected);
  }

  @Test
  public void should_return_this() {
    ByteAssert returned = assertions.isNotEqualTo(expected);
    assertSame(assertions, returned);
  }

  @Test
  public void should_throw_error_if_actual_is_null() {
    thrown.expect(AssertionError.class);
    actual = null;
    assertions.isNotEqualTo(expected);
  }

  @Test
  public void should_throw_error_if_expected_is_null() {
    thrown.expect(AssertionError.class);
    expected = null;
    assertions.isLessThan(expected);
  }

  @Test
  public void should_fail_if_actual_is_equal_to_expected() {
    thrown.expect(AssertionError.class);
    expected = 8;
    assertions.isNotEqualTo(expected);
  }
}
