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

import junit.framework.Assert;
import org.fest.test.ExpectedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.fest.test.ExpectedException.none;

/**
 * Tests for {@link CharArrayAssert#isNullOrEmpty()}.
 *
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class CharArrayAssert_isNullOrEmpty_Test {
  @Rule
  public ExpectedException thrown = none();
  private char[] actual = new char[0];
  private CharArrayAssert assertions;

  @Before
  public void setUp() {
    assertions = new CharArrayAssert(actual);
  }

  @Test
  public void should_pass_if_actual_is_empty() {
    assertions.isNullOrEmpty();
  }

  @Test
  public void should_pass_if_actual_is_null() {
    assertions = new CharArrayAssert(null);
    assertions.isNullOrEmpty();
  }

  @Test
  public void should_return_this_if_actual_is_empty() {
    CharArrayAssert returned = assertions.isNullOrEmpty();
    Assert.assertSame(returned, assertions);
  }

  @Test
  public void should_return_this_if_actual_is_null() {
    assertions = new CharArrayAssert(null);
    CharArrayAssert returned = assertions.isNullOrEmpty();
    Assert.assertSame(returned, assertions);
  }

  @Test
  public void should_fail_if_actual_is_not_null_and_not_empty() {
    thrown.expect(AssertionError.class);
    assertions = new CharArrayAssert(new char[1]);
    assertions.isNullOrEmpty();
  }
}
