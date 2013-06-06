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
import org.fest.util.Lists;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static org.fest.test.ExpectedException.none;

/**
 * Tests for {@link ListAssert#contains(Object, Index)}.
 *
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class ListAssert_contains_at_Index_Test {
  @Rule
  public ExpectedException thrown = none();
  private List<String> actual = Lists.newArrayList("one", "two");
  private Object value = "one";
  private Index index = Index.atIndex(0);
  private ListAssert assertions;

  @Before
  public void setUp() {
    assertions = new ListAssert(actual);
  }

  @Test
  public void should_throw_error_if_actual_is_null() {
    assertions = new ListAssert(null);
    assertions.contains(value, index);
  }

  @Test
  public void should_throw_error_if_expected_is_null() {
    assertions.contains(null, index);
  }

  @Test
  public void should_throw_error_if_index_is_null() {
    assertions.contains(value, null);
  }

  @Test
  public void should_fail_if_actual_does_not_contain_given_value_at_given_index() {
    thrown.expect(AssertionError.class);
    assertions.contains("five", index);
  }

  @Test
  public void should_fail_if_actual_is_empty() {
    thrown.expect(AssertionError.class);
    actual = Lists.emptyList();
    assertions = new ListAssert(actual);
    assertions.contains(value, index);
  }

  @Test
  public void should_pass_if_actual_contains_given_value_at_given_index() {
    assertions.contains(value, index);
  }
}
