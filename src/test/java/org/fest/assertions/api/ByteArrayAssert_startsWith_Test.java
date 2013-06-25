/*
 * Created on Dec 17, 2010
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

import static org.junit.Assert.assertSame;

import org.fest.test.ExpectedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Tests for {@link ByteArrayAssert#startsWith(byte...)}.
 *
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class ByteArrayAssert_startsWith_Test {
  @Rule
  public ExpectedException thrown = ExpectedException.none();
  private byte[] actual = { 6, 8, 16, 18 };
  private final byte[] sequence = { 6, 8 };
  private ByteArrayAssert assertions;

  @Before
  public void setUp() {
    assertions = new ByteArrayAssert(actual);
  }

  @Test
  public void should_return_this() {
    ByteArrayAssert returned = assertions.startsWith(sequence);
    assertSame(returned, assertions);
  }

  @Test
  public void should_pass_if_actual_starts_with_given_sequence() {
    assertions.startsWith(sequence);
  }

  @Test
  public void should_throw_error_if_actual_is_null() {
    actual = null;
    thrown.expect(AssertionError.class);
    assertions = new ByteArrayAssert(actual);
    assertions.startsWith(sequence);
  }

  @Test
  public void should_fail_if_sequence_is_null() {
    thrown.expect(NullPointerException.class);
    assertions.startsWith(null);
  }

  @Test
  public void should_fail_if_actual_is_empty() {
    thrown.expect(AssertionError.class);
    actual = new byte[0];
    assertions = new ByteArrayAssert(actual);
    assertions.startsWith(sequence);
  }

  @Test
  public void should_throw_error_if_sequence_is_empty() {
    thrown.expect(IllegalArgumentException.class);
    assertions.startsWith(new byte[0]);
  }

  @Test
  public void should_fail_if_actual_does_not_start_with_sequence() {
    thrown.expect(AssertionError.class);
    assertions.startsWith((byte) 1, (byte) 2);
  }
}
