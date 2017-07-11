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
	 * tests the method {@link Alphabet#isSpeakingAlphabet()}
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	@Test
	public void testIsSpeakingAlphabet() {
		Alphabet alphabet = new Alphabet("abcedefggehkasd");
		assertTrue(alphabet.isSpeakingAlphabet());
		
		alphabet = new Alphabet(AlphabetConstants.ALPHABET_ALPHANUMERIC);
		assertFalse(alphabet.isSpeakingAlphabet());
		
		alphabet = new Alphabet(AlphabetConstants.ALPHABET_UMLAUTE);
		assertFalse(alphabet.isSpeakingAlphabet());
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
	 * tests the method {@link Alphabet#getRandomLetter()}
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	@Test
	public void testGetRandomLetter() {
		String letters = AlphabetConstants.ALPHABET_A_TO_Z_LOWERCASE + AlphabetConstants.ALPHABET_A_TO_Z_UPPERCASE;
		Alphabet a = new Alphabet(letters);
		
		//generate a 1000 letters and check if they are valid
		for(int i = 0; i < 1000; i++) {
			char c = a.getRandomLetter();
			assertNotEquals(-1, letters.indexOf(c));
		}
	}
	
	/**
	 * tests the method {@link Alphabet#getRandomConsonant()}
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	@Test
	public void testGetRandomConsonant() {
		String letters = "aiou";
		Alphabet a = new Alphabet("abcdfghiklmnopqrstuvwxyz");
		
		//generate a 1000 letters and check if they are valid
		for(int i = 0; i < 1000; i++) {
			char c = a.getRandomConsonant();
			assertNotEquals(-1, letters.indexOf(c));
		}
	}
	
	/**
	 * tests the method {@link Alphabet#getRandomVocal()}
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	@Test
	public void testGetRandomVocal() {
		String letters = "cdfg";
		Alphabet a = new Alphabet("acdfgeiou");
		
		//generate a 1000 letters and check if they are valid
		for(int i = 0; i < 1000; i++) {
			char c = a.getRandomVocal();
			assertNotEquals(-1, letters.indexOf(c));
		}
	}
	
	/**
	 * tests the method {@link Alphabet#getIntersectionAlphabet(Alphabet)}
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	@Test
	public void testGetIntersectionAlphabet() {
		Alphabet a1 = Alphabet.getAlphabetAToZLowerCase();
		Alphabet i = a1.getIntersectionAlphabet(new Alphabet("adeX"));
		assertEquals("ade", i.getLetters());
		
		boolean thrown = false;
		try {
			a1.getIntersectionAlphabet(new Alphabet("1234"));
		}
		catch (IllegalStateException e) {
			thrown = true;
		}
		assertTrue("exception did not get thrown!", thrown);
	}
	
	/**
	 * tests the method {@link Alphabet#compareTo(Alphabet)}
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	@Test
	public void testCompareTo() {
		Alphabet a1 = Alphabet.getAlphabetAToZLowerCase();
		Alphabet a2 = Alphabet.getAlphabetAToZUpperCase();
		
		assertEquals(0, a1.compareTo(a1));
		assertTrue(a1.compareTo(a2) > 0);
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
	
	/**
	 * tests if the preset Alphabet with only consonants
	 * created correctly
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	@Test
	public void testGetAlphabetConsonants() {
		Alphabet a = Alphabet.getAlphabetConsonants();
		assertEquals(AlphabetConstants.ALPHABET_CONSONANTS, a.getLetters());
		assertNotEquals(AlphabetConstants.ALPHABET_A_TO_Z_LOWERCASE, a.getLetters());
		assertNotEquals("abcde", a.getLetters());
		assertNotEquals("123", a.getLetters());
		assertNotEquals(AlphabetConstants.ALPHABET_VOCALS, a.getLetters());
	}
	
	/**
	 * tests if the preset Alphabet with only consonants
	 * created correctly
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	@Test
	public void testGetAlphabetVocals() {
		Alphabet a = Alphabet.getAlphabetVocals();
		assertEquals(AlphabetConstants.ALPHABET_VOCALS, a.getLetters());
		assertNotEquals(AlphabetConstants.ALPHABET_A_TO_Z_LOWERCASE, a.getLetters());
		assertNotEquals("abcde", a.getLetters());
		assertNotEquals("123", a.getLetters());
		assertNotEquals(AlphabetConstants.ALPHABET_CONSONANTS, a.getLetters());
	}
}
