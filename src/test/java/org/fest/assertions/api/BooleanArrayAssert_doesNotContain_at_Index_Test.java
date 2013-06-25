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

import junit.framework.Assert;

import org.fest.assertions.data.Index;
import org.fest.test.ExpectedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Tests for {@link BooleanArrayAssert#doesNotContain(boolean, Index)}.
 *
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class BooleanArrayAssert_doesNotContain_at_Index_Test {

  private final Index index = Index.atIndex(0);
  @Rule
  public ExpectedException thrown = ExpectedException.none();
  private boolean[] actual = {true, false};
  private BooleanArrayAssert assertions;

  @Before
  public void setUp() {
    assertions = new BooleanArrayAssert(actual);
  }

  @Test
  public void should_return_this() {
    BooleanArrayAssert returned = assertions.doesNotContain(false, index);
    Assert.assertSame(returned, assertions);
  }

  @Test
  public void should_pass_if_actual_does_not_contain_expected_at_index() {
    assertions.doesNotContain(false, index);
  }

  @Test
  public void should_pass_if_actual_is_empty() {
    actual = new boolean[0];
    assertions.doesNotContain(false, index);
  }

  @Test
  public void should_fail_if_actual_contains_expected_at_index() {
    thrown.expect(AssertionError.class);
    assertions.doesNotContain(true, index);
  }

  @Test
  public void should_throw_error_if_actual_is_null() {
    thrown.expect(AssertionError.class);
    actual = null;
    assertions = new BooleanArrayAssert(actual);
    assertions.doesNotContain(false, index);
  }

  @Test
  public void should_fail_if_index_is_null() {
    thrown.expect(NullPointerException.class);
    assertions.doesNotContain(false, null);
  }

  @Test
  public void should_fail_if_index_is_invalid() {
    thrown.expect(IllegalArgumentException.class);
    assertions.doesNotContain(false, Index.atIndex(-1));
  }
}
