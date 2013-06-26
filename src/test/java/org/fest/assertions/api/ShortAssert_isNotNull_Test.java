/*
 * Created on Oct 20, 2010
 *
<<<<<<< HEAD
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
=======
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
>>>>>>> branch 'master' of https://github.com/alexruiz/fest-assert-2.x.git
 *
 * Copyright @2010-2013 the original author or authors.
 */
package org.fest.assertions.api;

import static org.fest.test.ExpectedException.none;

import org.fest.test.ExpectedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Tests for {@link ShortAssert#isNotNull()}.
 *
 * @author Yvonne Wang
 */
public class ShortAssert_isNotNull_Test {
  @Rule
  public ExpectedException thrown = none();
  private ShortAssert assertions;
  private Short actual;

  @Before
  public void setUp() {
    actual = new Short((short) 6);
    assertions = new ShortAssert(actual);
  }

  @Test
  public void should_fail_if_actual_is_null() {
    thrown.expect(AssertionError.class);
    assertions = new ShortAssert(null);
    assertions.isNotNull();
  }

  @Test
  public void should_pass_if_actual_is_not_null() {
    assertions.isNotNull();
  }
}
