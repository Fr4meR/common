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
package de.framersoft.common.test.password.generator;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.junit.Test;

import de.framersoft.common.constants.AlphabetConstants;
import de.framersoft.common.password.alphabet.Alphabet;
import de.framersoft.common.password.generator.PasswordGenerator;

/**
 * test case for the class {@link PasswordGenerator}
 * @author Tobias Hess
 * @since 11.07.2017
 */
public class PasswordGeneratorTest {

	/**
	 * tests the constructors
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	@Test
	public void testConstructors() {
		//constructor 1
		PasswordGenerator pg1 = new PasswordGenerator(Alphabet.getAlphabetAToZLowerCase(), 10);
		assertEquals(0, pg1.getAlphabet().compareTo(Alphabet.getAlphabetAToZLowerCase()));
		assertEquals(10, pg1.getLength());
		
		//constructor 2
		String letters = "abcdefgh";
		PasswordGenerator pg2 = new PasswordGenerator(letters, 22);
		assertEquals(0, pg2.getAlphabet().compareTo(new Alphabet(letters)));
		assertEquals(22, pg2.getLength());
		
		//check exceptions
		boolean thrown = false;
		try {
			new PasswordGenerator("", 12);
		}
		catch(InvalidParameterException e) {
			thrown = true;
		}
		assertTrue(thrown);
		
		thrown = false;
		try {
			new PasswordGenerator("abcdef", 0);
		}
		catch(InvalidParameterException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}
	
	@Test
	public void testSettersGetters() {
		final Alphabet aPrefix = Alphabet.getAlphabetAToZUpperCase();
		final Alphabet aPostfix = new Alphabet(AlphabetConstants.ALPHABET_NUMBERS);
		final int lengthPrefix = 1;
		final int lengthPostfix = 3;
		final boolean speakingPassword = false;
		
		PasswordGenerator pg = new PasswordGenerator(Alphabet.getAlphabetAToZLowerCase(), 10);
		pg.setAlphabetPrefix(aPrefix);
		pg.setAlphabetPostfix(aPostfix);
		pg.setLengthPrefix(lengthPrefix);
		pg.setLengthPostfix(lengthPostfix);
		pg.setSpeakingPassword(speakingPassword);
		
		assertEquals(aPrefix, pg.getAlphabetPrefix());
		assertEquals(aPostfix, pg.getAlphabetPostfix());
		assertEquals(lengthPrefix, pg.getLengthPrefix());
		assertEquals(lengthPostfix, pg.getLengthPostfix());
		assertEquals(speakingPassword, pg.isSpeakingPassword());
		
		//test the setters exceptions
		boolean thrown = false;
		try {
			pg.setLengthPrefix(-1);
		}
		catch(InvalidParameterException e) {
			thrown = true;
		}
		assertTrue(thrown);
		
		thrown = false;
		try {
			pg.setLengthPostfix(-1);
		}
		catch(InvalidParameterException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}
	
	@Test
	public void testGeneratePassword() {
		//check the exceptions
		PasswordGenerator pg = new PasswordGenerator(Alphabet.getAlphabetAToZLowerCase(), 12);
		pg.setLengthPrefix(15);
		boolean thrown = false;
		try {
			pg.generatePassword();
		}
		catch(IllegalStateException e) {
			thrown = true;
		}
		assertTrue(thrown);
		
		pg = new PasswordGenerator(Alphabet.getAlphabetAToZLowerCase(), 12);
		pg.setLengthPrefix(5);
		thrown = false;
		try {
			pg.generatePassword();
		}
		catch(InvalidParameterException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}
	
	/**
	 * tests a password generator: only main section with length 12
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	@Test
	public void testPasswordGenerator1() {
		PasswordGenerator pg = new PasswordGenerator(Alphabet.getAlphabetAToZLowerCase(), 12);
		checkPasswordGeneration(pg);
	}
	
	/**
	 * tests a password generator: prefix with length 3 and total length of 12
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	@Test
	public void testPasswordGenerator2() {
		PasswordGenerator pg = new PasswordGenerator(Alphabet.getAlphabetAToZLowerCase(), 12);
		pg.setAlphabetPrefix(Alphabet.getAlphabetAToZUpperCase());
		pg.setLengthPrefix(3);
		checkPasswordGeneration(pg);
	}
	
	/**
	 * tests a password generator: prefix with length 3, posftix with length 5
	 * and total length of 12
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	@Test
	public void testPasswordGenerator3() {
		PasswordGenerator pg = new PasswordGenerator(Alphabet.getAlphabetAToZLowerCase(), 12);
		pg.setAlphabetPrefix(Alphabet.getAlphabetAToZUpperCase());
		pg.setLengthPrefix(3);
		pg.setAlphabetPostfix(new Alphabet(AlphabetConstants.ALPHABET_NUMBERS));
		pg.setLengthPostfix(5);
		checkPasswordGeneration(pg);
	}
	
	/**
	 * tests a password generator: posftix with length 5 and total length of 12
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	@Test
	public void testPasswordGenerator4() {
		PasswordGenerator pg = new PasswordGenerator(Alphabet.getAlphabetAToZLowerCase(), 12);
		pg.setAlphabetPostfix(new Alphabet(AlphabetConstants.ALPHABET_NUMBERS));
		pg.setLengthPostfix(5);
		checkPasswordGeneration(pg);
	}
	
	/**
	 * tests a password generator: non speaking names
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	@Test
	public void testPasswordGenerator5() {
		PasswordGenerator pg = new PasswordGenerator(Alphabet.getAlphabetAToZLowerCase(), 12);
		pg.setSpeakingPassword(false);
		checkPasswordGeneration(pg);
	}
	
	/**
	 * checks the password generation of a given {@link PasswordGenerator}
	 * @author Tobias Hess
	 * @since 11.07.2017
	 * @param pg
	 * 		the {@link PasswordGenerator} to check
	 */
	private void checkPasswordGeneration(PasswordGenerator pg) {
		for(int i = 0; i < 250; i++) {
			String password = pg.generatePassword();
			assertEquals(pg.getLength(), password.length());
			
			//split password in the 3 sections
			String prefix = password.substring(0, pg.getLengthPrefix());
			String postfix = password.substring(pg.getLength() - pg.getLengthPostfix(), pg.getLength());
			String main = password.substring(pg.getLengthPrefix(), pg.getLength() - pg.getLengthPostfix());
			
			checkPasswordSection(pg.getAlphabetPrefix(), pg.getLengthPrefix(), prefix);
			checkPasswordSection(pg.getAlphabet(), pg.getLength() - pg.getLengthPrefix() - pg.getLengthPostfix(), main);
			checkPasswordSection(pg.getAlphabetPostfix(), pg.getLengthPostfix(), postfix);			
		}
	}
	
	/**
	 * checks a section of a password
	 * @author Tobias Hess
	 * @since 11.07.2017
	 * @param a
	 * 		the expected {@link Alphabet} used by the password section
	 * @param length
	 * 		the expected length of the password section
	 * @param section
	 * 		the password section to check
	 */
	private void checkPasswordSection(Alphabet a, int length, String section) {
		assertEquals(length, section.length());
		
		for(int i = 0; i < section.length(); i++) {
			char c = section.charAt(i);
			assertTrue(a.isLetterInAlphabet(c));
		}
	}
	
	/**
	 * tests the preset for internet passwords
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	@Test
	public void testGetInternetPasswordGenerator() {
		PasswordGenerator pg = PasswordGenerator.getInternetPasswordGenerator(12);
		checkPasswordGeneration(pg);
	}
}
