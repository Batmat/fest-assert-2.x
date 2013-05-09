/*
 * Created on Mar 31, 2013
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

import static org.fest.assertions.error.ShouldNotBeNull.shouldNotBeNull;
import static org.fest.assertions.test.TestFailures.expectedAssertionErrorNotThrown;
import static org.fest.test.ExpectedException.none;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.fest.assertions.description.Description;
import org.fest.assertions.error.ShouldNotBeLessThan;
import org.fest.test.ExpectedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Alex
 * @author Alex
 */
public class Characters_assertNotLessThan_Test {

  @Rule
  public ExpectedException thrown = none();

  private Characters characters;
  private Description description;
  private Failures failures;

  @Before
  public void setUp() {
    characters = new Characters();
    description = new TestDescription("testing");
    failures = spy(new Failures());
    characters.failures = failures;
  }

  @Test
  public void should_fail_if_actual_is_null() {
    String message = shouldNotBeNull().create(description);
    thrown.expect(AssertionError.class, message);
    characters.assertNotLessThan(description, null, 'a');
  }

  @Test
  public void should_fail_if_actual_is_less_than_other() {
    try {
      characters.assertNotLessThan(description, 'a', 'b');
    } catch (AssertionError e) {
      verify(failures).failure(description, ShouldNotBeLessThan.shouldNotBeLessThan('a', 'b'));
      return;
    }
    expectedAssertionErrorNotThrown();
  }

  @Test
  public void should_pass_if_actual_is_equal_to_other() {
    characters.assertNotLessThan(description, 'a', 'a');
  }

  @Test
  public void should_pass_if_actual_is_greater_than_other() {
    characters.assertNotLessThan(description, 'b', 'a');
  }
}
