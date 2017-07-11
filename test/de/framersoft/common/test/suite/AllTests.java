package de.framersoft.common.test.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import de.framersoft.common.test.password.alphabet.AlphabetTest;
import de.framersoft.common.test.password.generator.PasswordGeneratorTest;

/**
 * test suite that runs every test
 * @author Tobias Hess
 * @since 11.07.2017
 */
@RunWith(Suite.class)
@SuiteClasses({
	AlphabetTest.class,
	PasswordGeneratorTest.class
})
public class AllTests {

}
