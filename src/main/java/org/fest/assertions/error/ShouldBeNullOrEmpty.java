/*
 * Created on Sep 18, 2010
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
package org.fest.assertions.error;

/**
 * Creates an error message indicating that an assertion that verifies an enumeration is {@code null} or empty, failed.
 * Enumerations include collections, maps, arrays and {@code String}s.
 *
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class ShouldBeNullOrEmpty extends BasicErrorMessageFactory {
  /**
   * Creates a new instance of {@link ShouldBeNullOrEmpty}.
   *
   * @param actual the <em>actual</em> enumeration in the failed assertion.
   * @return the created of {@code ErrorMessageFactory}.
   */
  public static ErrorMessageFactory shouldBeNullOrEmpty(Object actual) {
    return new ShouldBeNullOrEmpty(actual);
  }

  private ShouldBeNullOrEmpty(Object actual) {
    super("expecting:\n null or empty but was:<%s>", actual);
  }
}
