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

import static org.fest.assertions.error.ShouldNotBeNull.shouldNotBeNull;
import static org.fest.test.ExpectedException.none;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;

import org.fest.assertions.description.Description;
import org.fest.assertions.error.ShouldNotBeGreaterThan;
import org.fest.assertions.test.TestFailures;
import org.fest.test.ExpectedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Alex
 * @author Alex
 */
public class BigDecimals_assertNotGreaterThan_Test {

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
    bigDecimals.assertNotGreaterThan(description, null, BigDecimal.ONE);
  }

  @Test
  public void should_fail_if_other_is_null() {
    thrown.expect(NullPointerException.class, "The given number should not be null");
    bigDecimals.assertNotGreaterThan(description, BigDecimal.ONE, null);
  }

  @Test
  public void should_fail_if_actual_is_greater_than_other() {
    try {
      bigDecimals.assertNotGreaterThan(description, BigDecimal.TEN, BigDecimal.ONE);
    } catch (AssertionError e) {
      verify(failures).failure(description,
          ShouldNotBeGreaterThan.shouldNotBeGreaterThan(BigDecimal.TEN, BigDecimal.ONE));
      return;
    }
    TestFailures.expectedAssertionErrorNotThrown();
  }

  @Test
  public void should_pass_if_actual_is_equal_to_other() {
    bigDecimals.assertNotGreaterThan(description, BigDecimal.ONE, BigDecimal.ONE);
  }

  @Test
  public void should_pass_if_actual_is_less_than_other() {
    bigDecimals.assertNotGreaterThan(description, BigDecimal.ONE, BigDecimal.TEN);
  }
}
