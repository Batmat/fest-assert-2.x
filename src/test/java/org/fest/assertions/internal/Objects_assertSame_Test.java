/*
 * Created on Sep 17, 2010
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
 * Copyright @2010-2012 the original author or authors.
 */
package org.fest.assertions.internal;

import static org.fest.assertions.test.TestFailures.expectedAssertionErrorNotThrown;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.same;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.fest.assertions.description.Description;
import org.fest.assertions.error.ErrorMessageFactory;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for {@link Objects#assertSame(Description, Object, Object)}.
 *
 * @author Alex Ruiz
 */
public class Objects_assertSame_Test {
  private Failures failures;
  private Objects objects;

  @Before
  public void setUp() {
    failures = spy(new Failures());
    objects = new Objects();
    objects.failures = failures;
  }

  @Test
  public void should_pass_if_objects_are_same() {
    Object actual = new Object();
    objects.assertSame(mock(Description.class), actual, actual);
  }

  @Test
  public void should_fail_if_objects_are_not_same() {
    Description description = new TestDescription("Testing");
    try {
      objects.assertSame(description, "Yoda", "Luke");
    } catch (AssertionError e) {
      assertEquals("[Testing] expected:<'Luke'> and actual:<'Yoda'> should refer to the same instance", e.getMessage());
      verify(failures).failure(same(description), any(ErrorMessageFactory.class));
      return;
    }
    throw expectedAssertionErrorNotThrown();
  }
}
