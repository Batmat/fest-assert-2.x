/*
 * Created on Dec 20, 2010
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

import static org.fest.assertions.error.ShouldBeEmpty.shouldBeEmpty;
import static org.fest.assertions.error.ShouldNotBeNull.shouldNotBeNull;
import static org.fest.assertions.test.TestFailures.expectedAssertionErrorNotThrown;
import static org.fest.test.ExpectedException.none;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.fest.assertions.description.Description;
import org.fest.test.ExpectedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Tests for <code>{@link FloatArrays#assertEmpty(Description, float[])}</code>.
 *
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class FloatArrays_assertEmpty_Test {

  @Rule
  public ExpectedException thrown = none();

  private FloatArrays arrays;
  private Description description;
  private Failures failures;

  @Before
  public void setUp() {
    arrays = new FloatArrays();
    description = new TestDescription("testing");
    Arrays parent = Arrays.instance();
    failures = spy(new Failures());
    parent.failures = failures;
  }

  @Test
  public void should_pass_if_actual_is_empty() {
    arrays.assertEmpty(description, new float[0]);
  }

  @Test
  public void should_fail_if_actual_is_not_empty() {
    float[] actual = { 8f };
    try {
      arrays.assertEmpty(description, actual);
    } catch (AssertionError e) {
      verify(failures).failure(description, shouldBeEmpty(actual));
      return;
    }
    throw expectedAssertionErrorNotThrown();
  }

  @Test
  public void should_fail_if_actual_is_null() {
    String message = shouldNotBeNull().create(description);
    thrown.expect(AssertionError.class, message);
    arrays.assertEmpty(description, null);
  }
}
