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
package de.framersoft.common.test.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import de.framersoft.common.test.password.alphabet.AlphabetTest;
import de.framersoft.common.test.password.generator.PasswordGeneratorTest;
import de.framersoft.common.test.password.strength.PasswordStrengthTest;

/**
 * test suite that runs every test
 * @author Tobias Hess
 * @since 11.07.2017
 */
@RunWith(Suite.class)
@SuiteClasses({
	AlphabetTest.class,
	PasswordGeneratorTest.class,
	PasswordStrengthTest.class
})
public class AllTests {

}
