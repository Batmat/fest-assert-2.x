/*
 * Created on Dec 16, 2010
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 *
 * Copyright @2010-2013 the original author or authors.
 */
package org.fest.assertions.api;

import static org.fest.test.ExpectedException.none;
import static org.junit.Assert.assertSame;

import org.fest.test.ExpectedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Tests for {@link BooleanArrayAssert#isNotEmpty()}.
 *
 * @author Yvonne Wang
 */
public class BooleanArrayAssert_isNotEmpty_Test  {
  @Rule
  public ExpectedException thrown = none();
  private boolean[] actual = new boolean[2];
  private BooleanArrayAssert assertions;

  @Before
  public void setUp() {
    assertions = new BooleanArrayAssert(actual);
  }

  @Test
  public void should_return_this() {
    BooleanArrayAssert returned = assertions.isNotEmpty();
    assertSame(returned, assertions);
  }

  @Test
  public void should_pass_if_actual_is_not_empty() {
    assertions.isNotEmpty();
  }

  @Test
  public void should_fail_if_actual_is_empty() {
    thrown.expect(AssertionError.class);
    actual = new boolean[0];
    assertions = new BooleanArrayAssert(actual);
    assertions.isNotEmpty();
  }

  @Test
  public void should_fail_if_actual_is_null() {
    thrown.expect(AssertionError.class);
    actual = null;
    assertions = new BooleanArrayAssert(actual);
    assertions.isNotEmpty();
  }
}
