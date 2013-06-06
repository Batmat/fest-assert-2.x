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

import org.fest.test.ExpectedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.fest.test.ExpectedException.none;

/**
 * Tests for {@link ObjectArrayAssert#startsWith(Object...)}.
 *
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class ObjectArrayAssert_startsWith_Test {
  @Rule
  public ExpectedException thrown = none();
  private Object[] actual = {6, 'b', 'c', 'd'};
  private Object[] sequence = {6, 'b'};
  private ObjectArrayAssert assertions;

  @Before
  public void setUp() {
    assertions = new ObjectArrayAssert(actual);
  }

  @Test
  public void should_pass_if_actual_starts_with_given_sequence() {
    assertions.startsWith(sequence);
  }

  @Test
  public void should_return_this_if_actual_starts_with_given_sequence() {
    assertions.startsWith(sequence);
  }

  @Test
  public void should_pass_if_actual_starts_is_itself() {
    assertions.startsWith(actual);
  }

  @Test
  public void should_pass_if_actual_starts_with_given_sequence_multiple_times() {
    assertions.startsWith(6, 'b', 6, 'b');
  }

  @Test
  public void should_throw_error_if_actual_is_null() {
    thrown.expect(AssertionError.class);
    assertions = new ObjectArrayAssert(null);
    assertions.startsWith(sequence);
  }

  @Test
  public void should_fail_if_actual_is_empty() {
    thrown.expect(AssertionError.class);
    assertions = new ObjectArrayAssert(new Object[0]);
    assertions.startsWith(sequence);
  }

  @Test
  public void should_throw_error_if_given_sequence_is_null() {
    thrown.expect(AssertionError.class);
    sequence = null;
    assertions.startsWith();
  }

  @Test
  public void should_throw_error_if_given_sequence_is_empty() {
    thrown.expect(AssertionError.class);
    assertions.startsWith();
  }

  @Test
  public void should_fail_if_actual_does_not_start_with_given_sequence() {
    thrown.expect(AssertionError.class);
    assertions.startsWith('e', 'f');
  }
}
