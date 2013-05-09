/*
 * Created on Dec 2, 2010
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
package org.fest.assertions.internal;

import static org.fest.assertions.error.ShouldStartWith.shouldStartWith;
import static org.fest.assertions.test.ErrorMessages.valuesToLookForIsEmpty;
import static org.fest.assertions.test.ErrorMessages.valuesToLookForIsNull;
import static org.fest.assertions.test.FailureMessages.actualIsNull;
import static org.fest.assertions.test.ObjectArrays.emptyArray;
import static org.fest.assertions.test.TestFailures.expectedAssertionErrorNotThrown;
import static org.fest.test.ExpectedException.none;
import static org.fest.util.Arrays.array;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.fest.assertions.description.Description;
import org.fest.test.ExpectedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Tests for <code>{@link ObjectArrays#assertStartsWith(Description, Object[], Object[])}</code>.
 *
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class ObjectArrays_assertStartsWith_Test {

  @Test
  public void should_throw_error_if_sequence_is_null() {
    thrown.expect(NullPointerException.class, valuesToLookForIsNull());
    arrays.assertStartsWith(description, actual, null);
  }

  @Test
  public void should_throw_error_if_sequence_is_empty() {
    thrown.expect(IllegalArgumentException.class, valuesToLookForIsEmpty());
    arrays.assertStartsWith(description, actual, emptyArray());
  }

  @Test
  public void should_fail_if_actual_is_null() {
    thrown.expect(AssertionError.class, actualIsNull());
    arrays.assertStartsWith(description, null, array("Yoda"));
  }

  @Test
  public void should_fail_if_sequence_is_bigger_than_actual() {
    Object[] sequence = { "Yoda", "Luke", "Leia", "Obi-Wan", "Han", "C-3PO", "R2-D2", "Anakin" };
    try {
      arrays.assertStartsWith(description, actual, sequence);
    } catch (AssertionError e) {
      verify(failures).failure(description, shouldStartWith(actual, sequence));
      return;
    }
    expectedAssertionErrorNotThrown();
  }

  @Test
  public void should_fail_if_actual_does_not_start_with_sequence() {
    Object[] sequence = { "Han", "C-3PO" };
    try {
      arrays.assertStartsWith(description, actual, sequence);
    } catch (AssertionError e) {
      verify(failures).failure(description, shouldStartWith(actual, sequence));
      return;
    }
    expectedAssertionErrorNotThrown();
  }

  @Test
  public void should_fail_if_actual_starts_with_first_elements_of_sequence_only() {
    Object[] sequence = { "Leia", "Obi-Wan", "Han" };
    try {
      arrays.assertStartsWith(description, actual, sequence);
    } catch (AssertionError e) {
      verify(failures).failure(description, shouldStartWith(actual, sequence));
      return;
    }
    expectedAssertionErrorNotThrown();
  }

  @Test
  public void should_fail_if_actual_does_not_start_with_entire_sequence() {
    Object[] sequence = { "Luke", "Leia", "Han" };
    try {
      arrays.assertStartsWith(description, actual, sequence);
    } catch (AssertionError e) {
      verify(failures).failure(description, shouldStartWith(actual, sequence));
      return;
    }
    expectedAssertionErrorNotThrown();
  }

  @Test
  public void should_pass_if_actual_starts_with_sequence() {
    arrays.assertStartsWith(description, actual, array("Yoda", "Luke", "Leia"));
  }

  @Test
  public void should_pass_if_actual_and_sequence_are_equal() {
    arrays.assertStartsWith(description, actual, array("Yoda", "Luke", "Leia"));
  }

  @Rule
  public ExpectedException thrown = none();

  private ObjectArrays arrays;
  private Failures failures;
  private Description description;
  private final Object[] actual = array("Yoda", "Luke", "Leia");

  @Before
  public void setUp() {
    arrays = ObjectArrays.instance();
    Arrays parent = Arrays.instance();
    failures = spy(new Failures());
    parent.failures = failures;
    description = new TestDescription("testing");
  }
}
