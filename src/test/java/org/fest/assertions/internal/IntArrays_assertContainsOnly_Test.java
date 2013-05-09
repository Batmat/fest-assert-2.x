/*
 * Created on Mar 20, 2013
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
package org.fest.assertions.internal;

import static org.fest.assertions.error.ShouldContainOnly.shouldContainOnly;
import static org.fest.assertions.test.TestFailures.expectedAssertionErrorNotThrown;
import static org.fest.test.ExpectedException.none;
import static org.fest.util.Sets.newLinkedHashSet;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.Set;

import org.fest.assertions.description.Description;
import org.fest.assertions.error.ShouldNotBeNull;
import org.fest.test.ExpectedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Alex Ruiz
 * @author Yvonne Wang
 *
 */
public class IntArrays_assertContainsOnly_Test {

  @Rule
  public ExpectedException thrown = none();

  private IntArrays arrays;
  private Description description;
  private Failures failures;

  @Before
  public void setUp() {
    arrays = new IntArrays();
    description = new TestDescription("testing");
    failures = spy(new Failures());
    Arrays parent = Arrays.instance();
    parent.failures = failures;
  }

  @Test
  public void should_fail_if_actual_is_null() {
    String message = ShouldNotBeNull.shouldNotBeNull().create(description);
    int[] other = new int[1];
    thrown.expect(AssertionError.class, message);
    arrays.assertContainsOnly(description, null, other);
  }

  @Test
  public void should_fail_if_other_is_null() {
    int[] actual = new int[1];
    thrown.expect(NullPointerException.class, "The array of values to look for should not be null");
    arrays.assertContainsOnly(description, actual, null);
  }

  @Test
  public void should_fail_if_other_is_empty() {
    int[] actual = new int[1];
    int[] other = new int[0];
    thrown.expect(IllegalArgumentException.class, "The array of values to look for should not be empty");
    arrays.assertContainsOnly(description, actual, other);
  }

  @Test
  public void should_fail_if_actual_does_not_contain_only_other() {
    int[] actual = { 1, 2, 3, 4 };
    int[] other = { 1, 2, 3 };
    Set<Integer> notExpected = asSet(actual);
    Set<Integer> notFound = containsOnly(notExpected, other);
    try {
      arrays.assertContainsOnly(description, actual, other);
    } catch (AssertionError e) {
      verify(failures).failure(description, shouldContainOnly(actual, other, notFound, notExpected));
      return;
    }
    throw expectedAssertionErrorNotThrown();
  }

  @Test
  public void should_pass_if_actual_contains_only_other_in_any_order() {
    int[] actual = { 1, 2, 3, 4 };
    int[] other = { 2, 1, 3, 4 };
    arrays.assertContainsOnly(description, actual, other);
  }

  private Set<Integer> containsOnly(Set<Integer> actual, int[] other) {
    Set<Integer> notExpected = newLinkedHashSet();
    Set<Integer> notFound = newLinkedHashSet();
    notExpected = actual;
    for (int e : other) {
      if (notExpected.contains(e)) {
        notExpected.remove(e);
      } else {
        notFound.add(e);
      }
    }
    return notFound;
  }

  private Set<Integer> asSet(int[] actual) {
    Set<Integer> set = newLinkedHashSet();
    for (int e : actual) {
      set.add(e);
    }
    return set;
  }
}
