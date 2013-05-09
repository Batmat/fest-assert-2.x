/*
 * Created on Apr 24, 2013
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

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * All tests for {@link BigDecimals}.
 *
 * @author Yvonne Wang
 */
@RunWith(Suite.class)
@SuiteClasses({
    BigDecimals_assertEqual_Test.class,
    BigDecimals_assertNotEqual_Test.class,
    BigDecimals_assertGreaterThan_Test.class,
    BigDecimals_assertLessThan_Test.class,
    BigDecimals_assertNotGreaterThan_Test.class,
    BigDecimals_assertNotLessThan_Test.class,
    BigDecimals_assertIsZero_Test.class,
    BigDecimals_assertIsNotZero_Test.class,
    BigDecimals_assertIsPositive_Test.class,
    BigDecimals_assertIsNegative_Test.class
})
public class BigDecimals_TestSuite {

}
