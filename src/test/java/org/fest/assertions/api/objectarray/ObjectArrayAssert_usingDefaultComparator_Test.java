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
package org.fest.assertions.api.objectarray;

import static junit.framework.Assert.assertSame;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Comparator;

import org.fest.assertions.api.ObjectArrayAssert;
import org.fest.assertions.api.ObjectArrayAssertBaseTest;
import org.fest.assertions.internal.ObjectArrays;
import org.fest.assertions.internal.Objects;
import org.junit.Before;
import org.mockito.Mock;

/**
 * Tests for <code>{@link org.fest.assertions.api.ObjectArrayAssert#usingDefaultComparator()}</code>.
 * 
 * @author Joel Costigliola
 * @author Mikhail Mazursky
 */
public class ObjectArrayAssert_usingDefaultComparator_Test extends ObjectArrayAssertBaseTest {

  @Mock
  private Comparator<Object[]> comparator;

  private ObjectArrays arraysBefore;

  @Before
  public void before() {
    initMocks(this);
    arraysBefore = getArrays(assertions);
    assertions.usingComparator(comparator);
  }

  @Override
  protected ObjectArrayAssert<Object> invoke_api_method() {
    return assertions.usingDefaultComparator();
  }

  @Override
  protected void verify_internal_effects() {
    assertSame(getObjects(assertions), Objects.instance());
    assertSame(getArrays(assertions), arraysBefore);
  }
}
