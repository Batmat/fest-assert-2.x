/*
 * Created on Apr 29, 2013
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

import static org.fest.assertions.error.ShouldNotContainNull.shouldNotContainNull;
import static org.fest.assertions.test.TestFailures.expectedAssertionErrorNotThrown;
import static org.fest.test.ExpectedException.none;
import static org.fest.util.Collections.list;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.fest.assertions.description.Description;
import org.fest.assertions.test.FailureMessages;
import org.fest.test.ExpectedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Yvonne Wang
 */
public class Lists_assertDoesNotContainNull_Test {

  @Rule
  public ExpectedException thrown = none();

  private Failures failures;
  private Lists lists;
  private Description description;
  private List<String> actual = list("Luke", "Yoda", "Leia");

  @Before
  public void setUp() {
    failures = spy(new Failures());
    lists = Lists.instance();
    lists.failures = failures;
    description = new TestDescription("testing");
  }

  @Test
  public void should_pass_if_actual_does_not_contain_null() {
    lists.assertDoesNotContainNull(description, actual);
  }

  @Test
  public void should_fail_if_actual_is_null() {
    thrown.expect(AssertionError.class, FailureMessages.actualIsNull());
    lists.assertDoesNotContainNull(description, null);
  }

  @Test
  public void should_fail_if_actual_contains_null() {
    actual = list("Han", null, "Luke");
    try {
      lists.assertDoesNotContainNull(description, actual);
    } catch (AssertionError e) {
      verify(failures).failure(description, shouldNotContainNull(actual));
      return;
    }
    expectedAssertionErrorNotThrown();
  }
}
