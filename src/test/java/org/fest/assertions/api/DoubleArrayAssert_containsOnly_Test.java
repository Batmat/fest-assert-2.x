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
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.fest.test.ExpectedException.none;

/**
 * Tests for {@link DoubleArrayAssert#containsOnly(double...)}.
 *
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class DoubleArrayAssert_containsOnly_Test {
  @Rule
  public ExpectedException thrown = none();
  private double[] actual = {6d, 8d, 10d};
  private double[] values = {6d, 6d, 8d, 8d, 10d, 10d};
  private DoubleArrayAssert assertions;

  @Before
  public void setUp() {
    assertions = new DoubleArrayAssert(actual);
  }

  @Test
  public void should_pass_if_actual_contains_only_given_value() {
    assertions.containsOnly(actual);
  }

  @Test
  public void should_return_this_if_actual_contains_only_given_values() {
    assertions.containsOnly(actual);
  }

  @Test
  public void should_pass_if_actual_contains_only_given_values_multiple_times() {
    assertions.containsOnly(values);
  }

  @Test
  public void should_throw_error_if_actual_is_null() {
    thrown.expect(AssertionError.class);
    assertions = new DoubleArrayAssert(null);
    assertions.containsOnly(values);
  }

  @Test
  public void should_fail_if_actual_is_empty() {
    thrown.expect(AssertionError.class);
    assertions = new DoubleArrayAssert(new double[0]);
    assertions.containsOnly(values);
  }

  @Test
  public void should_throw_error_if_given_value_is_null() {
    thrown.expect(AssertionError.class);
    values = null;
    assertions.containsOnly(values);
  }

  @Test
  public void should_throw_error_if_given_values_is_empty() {
    thrown.expect(AssertionError.class);
    assertions.containsOnly();
  }

  @Test
  public void should_fail_if_actual_does_not_contain_given_values() {
    thrown.expect(AssertionError.class);
    assertions.containsOnly(2d, 4d);
  }
}
