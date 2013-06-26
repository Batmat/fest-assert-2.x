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

import static org.fest.test.ExpectedException.none;

import java.util.Set;

import org.fest.test.ExpectedException;
import org.fest.util.Sets;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Tests for {@link SetAssert#containsSequence(Object...)}.
 *
 * @author Yvonne Wang
 */
public class SetAssert_containsSequence_Test {
  @Rule
  public ExpectedException thrown = none();
  private Set<String> actual = Sets.newLinkedHashSet("one", "two", "three", "four");
  private Object[] sequence = { "two", "three" };
  private SetAssert assertions;

  @Before
  public void setUp() {
    assertions = new SetAssert(actual);
  }

  @Test
  public void should_throw_error_if_actual_is_null() {
    actual = null;
    assertions = new SetAssert(actual);
    thrown.expect(AssertionError.class);
    assertions.containsSequence(sequence);
  }

  @Test
  public void should_throw_if_expected_is_null() {
    sequence = null;
    thrown.expect(NullPointerException.class);
    assertions.containsSequence(sequence);
  }

  @Test
  public void should_throw_if_expected_is_empty() {
    Object[] sequence = new Object[0];
    thrown.expect(IllegalArgumentException.class);
    assertions.containsSequence(sequence);
  }

  @Test
  public void should_fail_if_actual_is_empty() {
    actual = Sets.newHashSet();
    assertions = new SetAssert(actual);
    thrown.expect(AssertionError.class);
    assertions.containsSequence(sequence);
  }

  @Test
  public void should_fail_if_actual_does_not_contain_sequence() {
    Object[] sequence = { "two", "three", "five" };
    thrown.expect(AssertionError.class);
    assertions.containsSequence(sequence);
  }

  @Test
  public void should_fail_if_size_of_sequence_is_greater_than_size_of_actual() {
    Object[] sequence = { "two", "three", "one", "two", "three", "four" };
    thrown.expect(AssertionError.class);
    assertions.containsSequence(sequence);
  }

  @Test
  public void should_pass_if_actual_contains_sequence() {
    assertions.containsSequence(sequence);
  }

  @Test
  public void should_pass_if_actual_contains_itself() {
    assertions.containsSequence(actual.toArray());
  }
}
