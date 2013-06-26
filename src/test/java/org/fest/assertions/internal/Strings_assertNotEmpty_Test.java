/*
 * Created on Dec 26, 2010
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

import static org.fest.assertions.test.FailureMessages.actualIsNull;
import static org.fest.assertions.test.TestFailures.expectedAssertionErrorNotThrown;
import static org.fest.test.ExpectedException.none;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

import org.fest.assertions.description.Description;
import org.fest.test.ExpectedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Tests for {@link Strings#assertNotEmpty(Description, String)}.
 *
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class Strings_assertNotEmpty_Test {
  @Rule
  public ExpectedException thrown = none();

  private Failures failures;
  private Strings strings;

  @Before
  public void setUp() {
    failures = spy(new Failures());
    strings = new Strings();
    strings.failures = failures;
  }

  @Test
  public void should_pass_if_actual_is_not_empty() {
    strings.assertNotEmpty(mock(Description.class), "Yoda");
  }

  @Test
  public void should_fail_if_actual_is_null() {
    thrown.expect(AssertionError.class, actualIsNull());
    strings.assertNotEmpty(mock(Description.class), null);
  }

  @Test
  public void should_fail_if_actual_is_empty() {
    Description description = new TestDescription("Testing");
    try {
      strings.assertNotEmpty(description, "");
    } catch (AssertionError e) {
      assertEquals("[Testing] expecting:\n actual not to be empty", e.getMessage());
      return;
    }
    throw expectedAssertionErrorNotThrown();
  }
}
