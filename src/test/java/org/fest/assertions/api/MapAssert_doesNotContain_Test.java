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

import java.util.Map;

import org.fest.assertions.data.MapEntry;
import org.fest.test.ExpectedException;
import org.fest.util.Maps;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Tests for {@link MapAssert#doesNotContain(MapEntry...)}.
 *
 * @author Alex Ruiz
 * @author Nicolas François
 * @author Yvonne Wang
 */
public class MapAssert_doesNotContain_Test  {
  @Rule
  public ExpectedException thrown = ExpectedException.none();
  private Map<String, String> actual = Maps.newHashMap();
  private MapEntry entries = MapEntry.entry("one", "peach");
  private MapAssert assertions;

  @Before
  public void setUp() {
    actual.put("one", "apple");
    actual.put("two", "peach");
    assertions = new MapAssert(actual);
  }

  @Test
  public void should_pass_if_actual_does_not_contain_given_entries() {
    assertions.doesNotContain(entries);
  }

  @Test
  public void should_throw_error_if_actual_is_null() {
    thrown.expect(AssertionError.class);
    assertions = new MapAssert(null);
    assertions.doesNotContain(entries);
  }

  @Test
  public void should_throw_error_if_entries_is_null() {
    thrown.expect(NullPointerException.class);
    entries = null;
    assertions.doesNotContain(entries);
  }

  @Test
  public void should_pass_if_entries_is_empty() {
    entries = MapEntry.entry("", "");
    assertions.doesNotContain(entries);
  }

  @Test
  public void should_pass_if_actual_is_empty() {
    actual = Maps.newHashMap();
    assertions = new MapAssert(actual);
    assertions.doesNotContain(entries);
  }

  @Test
  public void should_fail_if_actual_contains_given_entries() {
    thrown.expect(AssertionError.class);
    assertions.doesNotContain(MapEntry.entry("one", "apple"));
  }
}
