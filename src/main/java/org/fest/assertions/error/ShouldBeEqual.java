/*
 * Created on Mar 28, 2013
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
package org.fest.assertions.error;

/**
 * Creates an error message indicating that an assertion that verifies that two objects are equal failed.
 *
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class ShouldBeEqual extends BasicErrorMessageFactory {

  /**
   * Creates a new {@link ShouldBeEqual}.
   *
   * @param actual the <em>actual</em> value in the failed assertion.
   * @param expected the value used in the failed assertion to compare the <em>actual</em> value to.
   * @return the created {@code ErrorMessageFactory}.
   */
  public static ErrorMessageFactory shouldBeEqual(Object actual, Object expected) {
    return new ShouldBeEqual(actual, expected);
  }

  private ShouldBeEqual(Object actual, Object expected) {
    super("expecting:\n<%s> should be equal to:<%s>", actual, expected);
  }
}
