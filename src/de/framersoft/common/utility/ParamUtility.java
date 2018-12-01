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

/**
 * Contains a collection of general static utility methods for checking method parameters
 * for validity. 
 * @author Tobias Hess
 * @since 2018-12-01
 */
public final class ParamUtility {

	/**
	 * Checks if the given number is zero. 
	 * @param number
	 * 		The number to check
	 * @throws InvalidParameterException
	 * 		If the given number is zero.
	 */
	public static void checkZero(int number) {
		if(number == 0) throw new InvalidParameterException("given paramter can't be zero");
	}
	
	/**
	 * Checks if the given number is negative.
	 * @param number
	 * 		The number to check.
	 * @throws InvalidParameterException
	 * 		If the given number is negative.
	 */
	public static void checkNegative(int number) {
		if(number < 0) throw new InvalidParameterException("given parameter can't be negative");
	}
	
	/**
	 * Checks if the given number is zero or negative.
	 * @param number
	 * 		The number to check.
	 * @throws
	 * 		If the given number is zero or negative.
	 */
	public static void checkZeroNegative(int number) {
		checkZero(number);
		checkNegative(number);
	}
}
