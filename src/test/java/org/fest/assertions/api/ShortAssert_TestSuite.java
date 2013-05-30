/*
 *
 *  * Created on Mar 29, 2009
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 *  * the License. You may obtain a copy of the License at
 *  *
 *  * http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 *  * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 *  * specific language governing permissions and limitations under the License.
 *  *
 *  * Copyright @2013 the original author or authors.
 *
 */

package org.fest.assertions.api;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * All tests for {@link ShortAssert}.
 *
 * @author Yvonne Wang
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
  ShortAssert_isNull_Test.class,
  ShortAssert_isNotNull_Test.class,
  ShortAssert_isEqualTo_short_Test.class,
  ShortAssert_isNotEqualTo_short_Test.class,
  ShortAssert_isGreaterThan_short_Test.class,
  ShortAssert_isNotLessThan_short_Test.class,
  ShortAssert_isLessThan_short_Test.class,
  ShortAssert_isNotGreaterThan_short_Test.class,
  ShortAssert_isEqualTo_short_wrapper_Test.class,
  ShortAssert_isNotEqualTo_short_wrapper_Test.class,
  ShortAssert_isGreaterThan_short_wrapper_Test.class,
  ShortAssert_isNotLessThan_short_wrapper_Test.class,
  ShortAssert_isLessThan_ObjectShort_Testshort_wrapper_Test.class,
  ShortAssert_isNotGreaterThan_short_wrapper_Test.class
})
public class ShortAssert_TestSuite {
}
