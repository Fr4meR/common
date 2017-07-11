/**
 * Copyright (C) 2017 Tobias Hess
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
package de.framersoft.common.constants;

/**
 * constants for password strength estimation
 * @author Tobias Hess
 * @since 11.07.2017
 */
public interface PasswordStrengthConstants {

	/**
	 * password strength: very weak
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	public static final int PASSWORD_STRENGTH_VERY_WEAK = 1;
	
	/**
	 * password strength: weak
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	public static final int PASSWORD_STRENGTH_WEAK = 2;
	
	/**
	 * password strength: moderate
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	public static final int PASSWORD_STRENGTH_MODERATE = 3;
	
	/**
	 * password strength: strong
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	public static final int PASSWORD_STRENGTH_STRONG = 4;
	
	/**
	 * password strength: very strong
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	public static final int PASSWORD_STRENGTH_VERY_STRONG = 5;
}
