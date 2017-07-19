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
 * contains the version informations for the 
 * common module
 * @author Tobias Hess
 * @since 19.07.2017
 */
public interface Version {
	
	/**
	 * version number
	 * @author Tobias Hess
	 * @since 19.07.2017
	 */
	public final static String VERSION = "1.0.0";
	
	/**
	 * version name
	 * @author Tobias Hess
	 * @since 19.07.2017
	 */
	public final static String VERSION_NAME = "Rasfahan";
	
	/**
	 * version date
	 * @author Tobias Hess
	 * @since 19.07.2017
	 */
	public final static String VERSION_DATE = "2017-07-19";

	/**
	 * a string containing all the version information to display
	 * @author Tobias Hess
	 * @since 19.07.2017
	 */
	public final static String VERSION_STRING = VERSION + "(" + VERSION_NAME + ") (" + VERSION_DATE + ")"; 
}
