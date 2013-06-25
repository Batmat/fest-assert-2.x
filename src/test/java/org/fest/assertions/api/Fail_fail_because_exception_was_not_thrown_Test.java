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

import org.fest.assertions.api.Fail;
import org.fest.test.ExpectedException;
import org.junit.Rule;
import org.junit.Test;

/**
 * Tests for {@link Fail#failBecauseExceptionWasNotThrown(Class)}.
 *
 * @author Joel Costigliola
 * @author Yvonne Wang
 */
public class Fail_fail_because_exception_was_not_thrown_Test {
  @Rule
  public ExpectedException thrown = none();

  @Test
  public void should_include_message_built_with_given_exception_name() {
    thrown.expect(AssertionError.class, "Expected NullPointerException to be thrown");
    Fail.failBecauseExceptionWasNotThrown(NullPointerException.class);
  }

  @Test
  public void should_include_message_built_with_given_throwable_name() {
    thrown.expect(AssertionError.class, "Expected OutOfMemoryError to be thrown");
    Fail.failBecauseExceptionWasNotThrown(OutOfMemoryError.class);
  }
}
