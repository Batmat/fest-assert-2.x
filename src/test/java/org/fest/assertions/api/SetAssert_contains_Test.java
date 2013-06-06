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

import org.fest.test.ExpectedException;
import org.fest.util.Sets;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Collection;
import java.util.Set;

import static org.fest.test.ExpectedException.none;

/**
 * Tests for {@link ListAssert#contains(Collection[])}.
 *
 * @author Yvonne Wang
 */
public class SetAssert_contains_Test {
  @Rule
  public ExpectedException thrown = none();
  private Set<String> actual = Sets.newLinkedHashSet("one", "two", "three");
  private Set<String> expected = Sets.newLinkedHashSet("two", "three");
  private SetAssert assertions;

  @Before
  public void setUp() {
    assertions = new SetAssert(actual);
  }

  @Test
  public void should_throw_error_if_actual_is_null() {
    actual = null;
    assertions = new SetAssert(actual);
    thrown.expect(AssertionError.class);
    assertions.contains(expected);
  }

  @Test
  public void should_throw_if_expected_is_null() {
    expected = null;
    thrown.expect(AssertionError.class);
    assertions.contains(expected);
  }

  @Test
  public void should_throw_if_expected_is_empty() {
    expected = Sets.newHashSet();
    thrown.expect(AssertionError.class);
    assertions.contains(expected);
  }

  @Test
  public void should_fail_if_actual_does_not_contain_expected() {
    expected = Sets.newLinkedHashSet("five");
    thrown.expect(AssertionError.class);
    assertions.contains(expected);
  }

  @Test
  public void should_fail_if_actual_is_empty() {
    actual = Sets.newHashSet();
    assertions = new SetAssert(actual);
    thrown.expect(AssertionError.class);
    assertions.contains(expected);
  }

  @Test
  public void should_pass_if_actual_contains_expected() {
    assertions.contains(expected);
  }

  @Test
  public void should_pass_if_actual_contains_itself() {
    assertions.contains(actual);
  }

  @Test
  public void should_pass_if_actual_contains_expected_in_different_order() {
    expected.add("one");
    assertions.contains(expected);
  }
}
