/*
 * Created on Mar 29, 2009
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

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.rules.ExpectedException.none;

/**
 * Tests for {@link ByteAssert#isNotGreaterThan(byte)}.
 *
 * @author Yvonne Wang
 */
public class ByteAssert_isNotGreaterThan_byte_Test {
  @Rule
  public ExpectedException thrown = none();
  private ByteAssert assertions;
  private Byte actual;

  @Before
  public void setUp() {
    actual = new Byte((byte) 6);
    assertions = new ByteAssert(actual);
  }

  @Test
  public void should_pass_if_actual_is_less_than_expected() {
    assertions.isNotGreaterThan((byte) 8);
  }

  @Test
  public void should_pass_if_actual_is_equal_to_expected() {
    assertions.isNotGreaterThan((byte) 6);
  }

  @Test
  public void should_fail_if_actual_is_less_than_expected() {
    thrown.expect(AssertionError.class);
    assertions.isNotGreaterThan((byte) 8);
  }

  @Test
  public void should_throw_error_if_actual_is_null() {
    thrown.expect(AssertionError.class);
    assertions = new ByteAssert(null);
    assertions.isNotGreaterThan((byte) 2);
  }
}
