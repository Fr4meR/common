package de.framersoft.common.test.password.strength;

import static org.junit.Assert.*;

import org.junit.Test;

import de.framersoft.common.password.strength.PasswordStrength;

/**
 * test case for the class {@link PasswordStrength}
 * @author Tobias Hess
 * @since 11.07.2017
 */
public class PasswordStrengthTest {

	private static final String PASSWORD_SAFE = "D13s3sP4ssw0rtS0llteS1cherSe2n_!";
	private static final String PASSWORD_NOT_SAFE = "password";
	
	/**
	 * tests the constructors (is only here to fullfill code coverage tests)
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	@Test
	public void testConstructor() {
		new PasswordStrength();
	}
	
	/**
	 * tests the method {@link PasswordStrength#calculatePasswordStrengthRating(String)}
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	 @Test
	public void testCalculatePasswordStrengthRating() {
		assertEquals(PasswordStrength.PASSWORD_STRENGTH_VERY_WEAK, PasswordStrength.calculatePasswordStrengthRating(PASSWORD_NOT_SAFE));
		assertEquals(PasswordStrength.PASSWORD_STRENGTH_WEAK, PasswordStrength.calculatePasswordStrengthRating("aaaaaaaaaa"));
		assertEquals(PasswordStrength.PASSWORD_STRENGTH_MODERATE, PasswordStrength.calculatePasswordStrengthRating("Rondra_02"));
		assertEquals(PasswordStrength.PASSWORD_STRENGTH_STRONG, PasswordStrength.calculatePasswordStrengthRating("Hesind_ä8"));
		assertEquals(PasswordStrength.PASSWORD_STRENGTH_VERY_STRONG, PasswordStrength.calculatePasswordStrengthRating(PASSWORD_SAFE));
	}
	
	/**
	 * tests the method {@link PasswordStrength#calculateCrackTime(String, int)}
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	@Test
	public void testCalculateCrackTime() {
		assertTrue(PasswordStrength.calculateCrackTime(PASSWORD_SAFE, 1000) > PasswordStrength.calculateCrackTime(PASSWORD_NOT_SAFE, 1000));
	}
	
	/**
	 * Test method for {@link PasswordStrength#calculateEntropy(java.lang.String)}.
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	@Test
	public void testCalculateEntropy() {
		int space1 = PasswordStrength.calculateSpace(PASSWORD_SAFE);
		int space2 = PasswordStrength.calculateSpace(PASSWORD_NOT_SAFE);
		
		double expectedEntropy1 = PASSWORD_SAFE.length() * Math.log(space1);
		double expectedEntropy2 = PASSWORD_NOT_SAFE.length() * Math.log(space2);
		
		assertEquals(expectedEntropy1, PasswordStrength.calculateEntropy(PASSWORD_SAFE), 0D);
		assertEquals(expectedEntropy2, PasswordStrength.calculateEntropy(PASSWORD_NOT_SAFE), 0D);
		
		assertTrue(PasswordStrength.calculateEntropy(PASSWORD_SAFE) > PasswordStrength.calculateEntropy(PASSWORD_NOT_SAFE));
	}

	/**
	 * Test method for {@link PasswordStrength#calculateSpace(java.lang.String)}.
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	@Test
	public void testCalculateSpace() {
		assertEquals(26, PasswordStrength.calculateSpace("onlylowercaseletters"));
		assertEquals(26, PasswordStrength.calculateSpace("ONLYUPPERCASELETTERS"));
		assertEquals(52, PasswordStrength.calculateSpace("lowercaseAnDUpperCaseLetters"));
		assertEquals(62, PasswordStrength.calculateSpace("UpperCaseLowerCaseAndNumbers123123"));
		assertEquals(10, PasswordStrength.calculateSpace("123"));
		assertEquals(68, PasswordStrength.calculateSpace("UpperLowerNumbers123Punctuation.-"));
		assertEquals(89, PasswordStrength.calculateSpace("UpperLowerNumbers123Punctuation.-AndSpecial{/"));
		assertEquals(6, PasswordStrength.calculateSpace("öäü"));
		assertEquals(58, PasswordStrength.calculateSpace("UpperLowerUmlÄüte"));
	}

}
