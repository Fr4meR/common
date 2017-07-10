package de.framersoft.common.test.password.alphabet;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.junit.Test;

import de.framersoft.common.constants.AlphabetConstants;
import de.framersoft.common.password.alphabet.Alphabet;
/**
 * test case for the class {@link Alphabet}
 * @author Tobias Hess
 * @since 10.07.2017
 */
public class AlphabetTest {

	/**
	 * tests the constructor for the InvalidParameterException
	 * when an empty string is given
	 * @author Tobias Hess
	 * @since 10.07.2017
	 */
	@Test(expected = InvalidParameterException.class)
	public void testAlphabetInvalidParameterException1(){
		new Alphabet("");
	}
	
	/**
	 * tests the constructor for the InvalidParameterException
	 * when null as string is given
	 * @author Tobias Hess
	 * @since 10.07.2017
	 */
	@Test(expected = InvalidParameterException.class)
	public void testAlphabetInvalidParameterException2(){
		new Alphabet(null);
	}
	
	/**
	 * tests the method {@link Alphabet#isLetterInAlphabet(char)}
	 * @author Tobias Hess
	 * @since 10.07.2017
	 */
	@Test
	public void testIsLetterInAlphabet() {
		Alphabet alphabet = new Alphabet(AlphabetConstants.ALPHABET_A_TO_Z_LOWERCASE);
		
		assertTrue("'a' should be in " + AlphabetConstants.ALPHABET_A_TO_Z_LOWERCASE, alphabet.isLetterInAlphabet('a'));
		assertFalse("'0' should not be in " + AlphabetConstants.ALPHABET_A_TO_Z_LOWERCASE, alphabet.isLetterInAlphabet('0'));
		assertFalse("'A' should not be in " + AlphabetConstants.ALPHABET_A_TO_Z_LOWERCASE, alphabet.isLetterInAlphabet('A'));
	}

	/**
	 * tests the method {@link Alphabet#getLetters()}
	 * @author Tobias Hess
	 * @since 10.07.2017
	 */
	@Test
	public void testGetLetters() {
		Alphabet alphabet = new Alphabet(AlphabetConstants.ALPHABET_A_TO_Z_LOWERCASE);
		
		assertEquals("the letters in the alphabet should be the same", AlphabetConstants.ALPHABET_A_TO_Z_LOWERCASE, alphabet.getLetters());
		assertNotEquals("the letters in the alphabet should'nt be the same", "abcd", alphabet.getLetters());
	}

	/**
	 * tests if the preset Alphabet with a-z is
	 * created correctly
	 * @author Tobias Hess
	 * @since 10.07.2017
	 */
	@Test
	public void testGetAlphabetAToZLowerCase() {
		Alphabet a = Alphabet.getAlphabetAToZLowerCase();
		assertEquals(AlphabetConstants.ALPHABET_A_TO_Z_LOWERCASE, a.getLetters());
		assertNotEquals(AlphabetConstants.ALPHABET_A_TO_Z_UPPERCASE, a.getLetters());
		assertNotEquals("abcde", a.getLetters());
		assertNotEquals("123", a.getLetters());
	}
	
	/**
	 * tests if the preset Alphabet with A-Z is
	 * created correctly
	 * @author Tobias Hess
	 * @since 10.07.2017
	 */
	@Test
	public void testGetAlphabetAToZUpperCase() {
		Alphabet a = Alphabet.getAlphabetAToZUpperCase();
		assertEquals(AlphabetConstants.ALPHABET_A_TO_Z_UPPERCASE, a.getLetters());
		assertNotEquals(AlphabetConstants.ALPHABET_A_TO_Z_LOWERCASE, a.getLetters());
		assertNotEquals("abcde", a.getLetters());
		assertNotEquals("123", a.getLetters());
	}
}
