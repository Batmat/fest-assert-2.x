/*
 * Created on Jul 25, 2010
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
package org.fest.assertions.core;

import javax.annotation.Nonnull;

/**
 * Assertions applicable to groups of values that can be enumerated (e.g. arrays, collections or strings.)
 *
 * @param <S> the type of the assertion objects.
 *
 * @author Yvonne Wang
 * @author Alex Ruiz
 */
public interface EnumerableAssert<S> {

  /**
   * Verifies that the <em>actual</em> enumeration is {@code null} or empty.
   *
   * @return {@code this} the assertion object.
   * @throws AssertionError if the <em>actual</em> enumeration is not {@code null} or not empty.
   */
  S isNullOrEmpty();

  /**
   * Verifies that the <em>actual</em> enumeration is empty.
   *
   * @return {@code this} the assertion object.
   * @throws AssertionError if the <em>actual</em> enumeration is not empty.
   */
  S isEmpty();

  /**
   * Verifies that the <em>actual</em> enumeration is not empty.
   *
   * @return {@code this} assertion object.
   * @throws AssertionError if the <em>actual</em> enumeration is empty.
   */
  @Nonnull
  S isNotEmpty();

  /**
   * Verifies that the number of values in the <em>actual</em> enumeration is equal to the given one.
   *
   * @param expected the expected number of values in the <em>actual</em> enumeration.
   * @return {@code this} assertion object.
   * @throws AssertionError if the number of values of the <em>actual</em> enumeration is not equal to the given one.
   */
  @Nonnull
  S hasSize(int expected);
}
