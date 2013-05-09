/*
 * Created on Mar 29, 2013
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

import static org.fest.assertions.error.ShouldNotBeEqual.shouldNotBeEqual;
import static org.fest.assertions.error.ShouldNotBeNull.shouldNotBeNull;
import static org.fest.assertions.test.TestFailures.expectedAssertionErrorNotThrown;
import static org.fest.test.ExpectedException.none;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;

import org.fest.assertions.description.Description;
import org.fest.test.ExpectedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Alex
 * @author Alex
 */
public class BigDecimals_assertNotEqual_Test {

  @Rule
  public ExpectedException thrown = none();

  private BigDecimals bigDecimals;
  private Description description;
  private Failures failures;

  @Before
  public void setUp() {
    bigDecimals = new BigDecimals();
    description = new TestDescription("testing");
    failures = spy(new Failures());
    Comparables comparables = Comparables.instance();
    comparables.failures = failures;
  }

  @Test
  public void should_fail_if_actual_is_null() {
    String message = shouldNotBeNull().create(description);
    thrown.expect(AssertionError.class, message);
    bigDecimals.assertNotEqual(description, null, BigDecimal.ONE);
  }

  @Test
  public void should_fail_if_expected_is_null() {
    thrown.expect(NullPointerException.class, "The given number should not be null");
    bigDecimals.assertNotEqual(description, BigDecimal.ONE, null);
  }

  @Test
  public void should_fail_if_acutal_is_equal_to_expected() {
    try {
      bigDecimals.assertNotEqual(description, BigDecimal.ONE, BigDecimal.ONE);
    } catch (AssertionError e) {
      verify(failures).failure(description, shouldNotBeEqual(BigDecimal.ONE, BigDecimal.ONE));
      return;
    }
    expectedAssertionErrorNotThrown();
  }

  @Test
  public void should_pass_if_actual_is_not_equal_to_expected() {
    bigDecimals.assertNotEqual(description, BigDecimal.ONE, BigDecimal.TEN);
  }
}
