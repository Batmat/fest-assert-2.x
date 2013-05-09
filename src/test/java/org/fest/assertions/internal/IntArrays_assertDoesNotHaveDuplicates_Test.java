/*
 * Created on Mar 22, 2013
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

import static org.fest.assertions.error.ShouldNotHaveDuplicates.shouldNotHaveDuplicates;
import static org.fest.assertions.test.TestFailures.expectedAssertionErrorNotThrown;
import static org.fest.assertions.util.ArrayWrapperList.wrap;
import static org.fest.test.ExpectedException.none;
import static org.fest.util.Collections.duplicatesFrom;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.Collection;

import org.fest.assertions.description.Description;
import org.fest.assertions.error.ShouldNotBeNull;
import org.fest.assertions.util.ArrayWrapperList;
import org.fest.test.ExpectedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Alex Ruiz
 * @author Yvonne Wang
 *
 */
public class IntArrays_assertDoesNotHaveDuplicates_Test {

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
    thrown.expect(AssertionError.class, message);
    arrays.assertDoesNotHaveDuplicates(description, null);
  }

  @Test
  public void should_pass_if_actual_does_not_have_duplicates() {
    int[] actual = { 1, 2, 3 };
    arrays.assertDoesNotHaveDuplicates(description, actual);
  }

  @Test
  public void should_fail_if_actual_has_duplicates() {
    int[] actual = { 1, 2, 2, 3, 2, 4 };
    ArrayWrapperList wrapped = wrap(actual);
    Collection<Object> duplicates = duplicatesFrom(wrapped);
    try {
      arrays.assertDoesNotHaveDuplicates(description, actual);
    } catch (AssertionError e) {
      verify(failures).failure(description, shouldNotHaveDuplicates(actual, duplicates));
      return;
    }
    throw expectedAssertionErrorNotThrown();
  }
}
