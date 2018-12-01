/**
 * Copyright (C) 2018 Tobias Hess
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.framersoft.common.utility;

import java.security.InvalidParameterException;

import static de.framersoft.common.utility.ParamUtility.*;

import org.junit.Test;
/**
 * Test case for {@link ParamUtility}
 * @author Tobias Hess
 * @since 2018-12-01
 */
public class ParamUtilityTest {

	/**
	 * Tests that the method does'nt throw an exception
	 */
	@Test
	public void testCheckZeroNoException() {
		checkZero(1);
		checkZero(123);
		checkZero(42);
		checkZero(6836);
		
		checkZero(-1);
		checkZero(-23);
		checkZero(-371);
		checkZero(-12);
	}
	
	/**
	 * Tests that the method does throw an {@link InvalidParameterException}.
	 */
	@Test(expected=InvalidParameterException.class)
	public void testCheckZeroException() {
		checkZero(0);
	}
	
	/**
	 * Tests that the method doesn't throw an exception.
	 */
	@Test
	public void testCheckNegativeNoException() {
		checkNegative(0);
		checkNegative(1);
		checkNegative(123);
		checkNegative(42);
		checkNegative(6836);
	}

	/**
	 * Tests that the method does throw an {@link InvalidParameterException}.
	 */
	@Test(expected=InvalidParameterException.class)
	public void testCheckNegativeException1() {
		checkNegative(-1);
	}

	/**
	 * Tests that the method does throw an {@link InvalidParameterException}.
	 */
	@Test(expected=InvalidParameterException.class)
	public void testCheckNegativeException2() {
		checkNegative(-42);
	}
	
	/**
	 * Tests that the method does throw an {@link InvalidParameterException}.
	 */
	@Test(expected=InvalidParameterException.class)
	public void testCheckNegativeException3() {
		checkNegative(-123);
	}
	
	/**
	 * Tests that the method doesn't throw an exception.
	 */
	@Test
	public void testCheckZeroNegativeNoException() {
		checkZeroNegative(1);
		checkZeroNegative(123);
		checkZeroNegative(42);
		checkZeroNegative(6836);
	}

	/**
	 * Tests that the method does throw an {@link InvalidParameterException}.
	 */
	@Test(expected=InvalidParameterException.class)
	public void testCheckZeroNegativeException1() {
		checkZeroNegative(0);
	}
	

	/**
	 * Tests that the method does throw an {@link InvalidParameterException}.
	 */
	@Test(expected=InvalidParameterException.class)
	public void testCheckZeroNegativeException2() {
		checkZeroNegative(-1);
	}
	

	/**
	 * Tests that the method does throw an {@link InvalidParameterException}.
	 */
	@Test(expected=InvalidParameterException.class)
	public void testCheckZeroNegativeException3() {
		checkZeroNegative(-42);
	}
	

	/**
	 * Tests that the method does throw an {@link InvalidParameterException}.
	 */
	@Test(expected=InvalidParameterException.class)
	public void testCheckZeroNegativeException4() {
		checkZeroNegative(-12356);
	}
}
