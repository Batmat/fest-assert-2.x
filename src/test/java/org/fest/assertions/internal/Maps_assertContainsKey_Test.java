/*
 * Created on Jun 3, 2012
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
 * Copyright @2010-2013 the original author or authors.
 */
package org.fest.assertions.internal;

import static org.fest.assertions.data.MapEntry.entry;
import static org.fest.assertions.error.ShouldContainKey.shouldContainKey;
import static org.fest.assertions.test.FailureMessages.actualIsNull;
import static org.fest.assertions.test.Maps.newMap;
import static org.fest.assertions.test.TestFailures.expectedAssertionErrorNotThrown;
import static org.fest.test.ExpectedException.none;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.Map;

import org.fest.assertions.description.Description;
import org.fest.test.ExpectedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Tests for <code>{@link Maps#assertContainsKey(Description, Map, Object)}</code>.
 *
 * @author Nicolas François
 * @author Joel Costigliola
 * @author Yvonne Wang
 */
public class Maps_assertContainsKey_Test {

  @Rule
  public ExpectedException thrown = none();

  private Maps maps;
  private Failures failures;
  private Description description;
  @SuppressWarnings("unchecked")
  private final Map<String, String> actual = (Map<String, String>) newMap(entry("name", "Yoda"),
      entry("princess", "Leia"));

  @Before
  public void setUp() {
    maps = Maps.instance();
    failures = spy(new Failures());
    maps.failures = failures;
    description = new TestDescription("testing");
  }

  @Test
  public void should_pass_if_actual_contains_given_key() {
    maps.assertContainsKey(description, actual, "name");
  }

  @Test
  public void should_fail_if_actual_is_null() {
    thrown.expect(AssertionError.class, actualIsNull());
    maps.assertContainsKey(description, null, "name");
  }

  @Test
  public void should_pass_if_actual_contains_null_key() {
    actual.put(null, "value");
    maps.assertContainsKey(description, actual, null);
  }

  @Test
  public void should_fail_if_given_key_is_null_but_actual_does_not_have_null_key() {
    try {
      maps.assertContainsKey(description, actual, null);
    } catch (AssertionError e) {
      verify(failures).failure(description, shouldContainKey(actual, null));
      return;
    }
    expectedAssertionErrorNotThrown();
  }

  @Test
  public void should_fail_if_actual_does_not_contain_key() {
    String key = "power";
    try {
      maps.assertContainsKey(description, actual, key);
    } catch (AssertionError e) {
      verify(failures).failure(description, shouldContainKey(actual, key));
      return;
    }
    expectedAssertionErrorNotThrown();
  }
}
