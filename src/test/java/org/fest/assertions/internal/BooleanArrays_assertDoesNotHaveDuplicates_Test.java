/*
 * Created on Dec 15, 2010
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

import static org.fest.assertions.error.ShouldNotHaveDuplicates.shouldNotHaveDuplicates;
import static org.fest.assertions.test.BooleanArrays.emptyArray;
import static org.fest.assertions.test.BooleanArrays.newArray;
import static org.fest.assertions.test.FailureMessages.actualIsNull;
import static org.fest.assertions.test.TestFailures.expectedAssertionErrorNotThrown;
import static org.fest.util.Sets.newLinkedHashSet;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.fest.assertions.description.Description;
import org.fest.test.ExpectedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Tests for <code>{@link BooleanArrays#assertDoesNotHaveDuplicates(Description, boolean[])}</code>.
 *
 * @author Alex Ruiz
 * @author Joel Costigliola
 * @author Yvonne Wang
 */
public class BooleanArrays_assertDoesNotHaveDuplicates_Test {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  private BooleanArrays arrays;
  private Description description;
  private Failures failures;
  private boolean[] actual = { true, false };

  @Before
  public void setUp() {
    arrays = new BooleanArrays();
    description = new TestDescription("testing");
    failures = spy(new Failures());
    Arrays parent = Arrays.instance();
    parent.failures = failures;
  }

  @Test
  public void should_pass_if_actual_does_not_have_duplicates() {
    arrays.assertDoesNotHaveDuplicates(description, actual);
  }

  @Test
  public void should_pass_if_actual_is_empty() {
    arrays.assertDoesNotHaveDuplicates(description, emptyArray());
  }

  @Test
  public void should_fail_if_actual_is_null() {
    thrown.expect(AssertionError.class, actualIsNull());
    arrays.assertDoesNotHaveDuplicates(description, null);
  }

  @Test
  public void should_fail_if_actual_contains_duplicates() {
    actual = newArray(true, true, false);
    try {
      arrays.assertDoesNotHaveDuplicates(description, actual);
    } catch (AssertionError e) {
      verify(failures).failure(description, shouldNotHaveDuplicates(actual, newLinkedHashSet(true)));
      return;
    }
    expectedAssertionErrorNotThrown();
  }
}
