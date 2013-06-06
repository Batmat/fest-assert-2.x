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

import org.fest.assertions.data.Index;
import org.fest.test.ExpectedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static junit.framework.Assert.assertSame;
import static org.fest.test.ExpectedException.none;

/**
 * Tests for {@link CharArrayAssert#contains(Character, Index)}.
 *
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class CharArrayAssert_contains_at_Index_Test {
  @Rule
  public ExpectedException thrown = none();
  private char[] actual = {'a', 'b', 'c'};
  private Character value = 'b';
  private Index index = Index.atIndex(2);
  private CharArrayAssert assertions;

  @Before
  public void setUp() {
    assertions = new CharArrayAssert(actual);
  }

  @Test
  public void should_pass_if_actual_does_not_contain_given_value_at_given_index() {
    assertions.doesNotContain(value, index);
  }

  @Test
  public void should_return_this_if_actual_does_not_contain_given_value_at_given_index() {
    CharArrayAssert returned = assertions.doesNotContain(value, index);
    assertSame(returned, assertions);
  }

  @Test
  public void should_throw_error_if_actual_is_null() {
    thrown.expect(AssertionError.class);
    assertions = new CharArrayAssert(null);
    assertions.doesNotContain(value, index);
  }

  @Test
  public void should_throw_error_if_actual_is_empty() {
    thrown.expect(AssertionError.class);
    assertions = new CharArrayAssert(new char[0]);
    assertions.doesNotContain(value, index);
  }

  @Test
  public void should_throw_error_if_given_value_is_null() {
    thrown.expect(AssertionError.class);
    assertions.doesNotContain(null, index);
  }

  @Test
  public void should_throw_error_if_given_index_is_null() {
    thrown.expect(AssertionError.class);
    assertions.doesNotContain(value, null);
  }

  @Test
  public void should_fail_if_actual_contains_given_value_at_given_index() {
    thrown.expect(AssertionError.class);
    assertions.doesNotContain('c', index);
  }
}
