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
