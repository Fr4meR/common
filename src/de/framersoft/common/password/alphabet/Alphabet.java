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
package de.framersoft.common.password.alphabet;

import java.security.InvalidParameterException;
import java.security.SecureRandom;

import de.framersoft.common.constants.AlphabetConstants;

/**
 * This class represents an alphabet
 * @author Tobias Hess
 * @since 10.07.2017
 */
public class Alphabet implements AlphabetConstants, Comparable<Alphabet>{
	
	/**
	 * the string of letters that is used by the 
	 * alphabet
	 * @author Tobias Hess
	 * @since 10.07.2017
	 */
	private String letters = "";
	
	/**
	 * a cryptographically strong random number generator, that is used to
	 * retrieve random elements out of the Alphabet.
	 * @author Tobias Hess
	 * @since 21.07.2017
	 */
	private SecureRandom random = null;
	
	/**
	 * constructor 1
	 * @author Tobias Hess
	 * @since 10.07.2017
	 * @param letters
	 * 		a string of letters to use for the alphabet
	 * @throws InvalidParameterException
	 * 		exception gets thrown when the string of letters to use 
	 * 		for the alphabet is empty or null
	 */
	public Alphabet(String letters) {
		setLetters(letters);
	}
	
	/**
	 * checks wheter a given char is in the alphabet
	 * @author Tobias Hess
	 * @since 10.07.2017
	 * @param letter
	 * 		the letter we want to check for
	 * @return
	 * 		true if the given letter is in the alphabet,
	 * 		false otherwise.
	 */
	public boolean isLetterInAlphabet(char letter) {
		boolean inAlphabet = false;
		
		for(int i = 0; i < getLetters().length(); i++) {
			char c = getLetters().charAt(i);
			
			if(c == letter) {
				inAlphabet = true;
				break;
			}
		}
		
		return inAlphabet;	
	}
	
	/**
	 * checks if the alphabet is a speaking alphabet.
	 * speaking means that a random character from the 
	 * alphabet is either an consonant or an vocal.
	 * @author Tobias Hess
	 * @since 11.07.2017
	 * @return
	 * 		true if the alphabet is speaking, false otherwise.
	 */
	public boolean isSpeakingAlphabet() {
		Alphabet speakable = new Alphabet(AlphabetConstants.ALPHABET_A_TO_Z);
		
		boolean isSpeakable = true;
		for(int i = 0; i < getLetters().length(); i++) {
			char c = getLetters().charAt(i);
			if(!speakable.isLetterInAlphabet(c)) {
				isSpeakable = false;
			}
		}
		return isSpeakable;
	}
	
	/**
	 * @author Tobias Hess
	 * @since 11.07.2017
	 * @return
	 * 		a random letter from the alphabet
	 */
	public char getRandomLetter() {
		 if(random == null) {
			 random = new SecureRandom();
		 }
		 final int i = random.nextInt(getLetters().length());
		 
		 return getLetters().charAt(i);
	}
	
	/**
	 * returns a random consonant from the Alphabet
	 * @author Tobias Hess
	 * @since 11.07.2017
	 * @throws IllegalStateException
	 * 		thrown if no consonants are in the Alphabet
	 * @return
	 * 		random consonant from the Alphabet
	 */
	public char getRandomConsonant() {
		//get the consonants of the alphabet
		Alphabet consonants = getIntersectionAlphabet(Alphabet.getAlphabetConsonants());
		return consonants.getRandomLetter();
	}
	
	/**
	 * returns a random vocal from the Alphabet
	 * @author Tobias Hess
	 * @since 11.07.2017
	 * @throws IllegalStateException
	 * 		thrown if no vocals are in the Alphabet
	 * @return
	 * 		random vocal from the Alphabet
	 */
	public char getRandomVocal() {
		//get the consonants of the alphabet
		Alphabet vocals = getIntersectionAlphabet(Alphabet.getAlphabetVocals());
		return vocals.getRandomLetter();
	}
	
	/**
	 * gets an {@link Alphabet} representing the intersection with
	 * the given {@link Alphabet} a
	 * @author Tobias Hess
	 * @since 11.07.2017
	 * @param a
	 * 		{@link Alphabet} to intersect with
	 * @throws IllegalStateException
	 * 		gets thrown if the resulting alphabet would be empty
	 * @return
	 * 		{@link Alphabet} containing the letters that are in both
	 * 		Alphabets
	 */
	public Alphabet getIntersectionAlphabet(Alphabet a) {		
		StringBuilder sb = new StringBuilder();
		
		//extract the consonants from the letters
		for(int i = 0; i < a.getLetters().length(); i++) {
			char letter = a.getLetters().charAt(i);
			
			if(isLetterInAlphabet(letter)) {
				sb.append(letter);
			}
		}
		
		//if no letters are in the alphabet throw an exception
		if(sb.length() <= 0) {
			throw new IllegalStateException("in the alphabet '" + getLetters() + "' are no occurences of '" + a.getLetters() + "'");
		}
		
		return new Alphabet(sb.toString());
	}
	
	/**
	 * sets the letters the alphabet is using
	 * @author Tobias Hess
	 * @since 10.07.2017
	 * @param letters
	 * 		the letters to set for the alphabet
	 * @throws InvalidParameterException
	 * 		exception gets thrown when the string of letters to use 
	 * 		for the alphabet is empty or null
	 */
	private void setLetters(String letters) {
		if(letters == null || letters.isEmpty()) {
			throw new InvalidParameterException();
		}
		
		this.letters = letters;
	}
	
	/**
	 * @author Tobias Hess
	 * @since 10.07.2017
	 * @return
	 * 		the string of letters that is used by the alphabet
	 */
	public String getLetters() {
		return this.letters;
	}
	
	/**
	 * creates an instance of {@link Alphabet} with the letters
	 * A-Z 
	 * @author Tobias Hess
	 * @since 10.07.2017
	 * @return 
	 * 		an instance of {@link Alphabet} with the letters
	 * 		A-Z
	 */
	public static Alphabet getAlphabetAToZUpperCase() {
		return new Alphabet(AlphabetConstants.ALPHABET_A_TO_Z_UPPERCASE);
	}
	
	/**
	 * creates an instance of {@link Alphabet} with the letters
	 * a-z 
	 * @author Tobias Hess
	 * @since 10.07.2017
	 * @return 
	 * 		an instance of {@link Alphabet} with the letters
	 * 		a-z
	 */
	public static Alphabet getAlphabetAToZLowerCase() {
		return new Alphabet(AlphabetConstants.ALPHABET_A_TO_Z_LOWERCASE);
	}
	
	/**
	 * creates an instance of {@link Alphabet} containing
	 * only consonants
	 * @author Tobias Hess
	 * @since 11.07.2017
	 * @return
	 * 		{@link Alphabet} containing only consonants
	 */
	public static Alphabet getAlphabetConsonants() {
		return new Alphabet(AlphabetConstants.ALPHABET_CONSONANTS);
	}
	
	/**
	 * creates an instance of {@link Alphabet} containing 
	 * only vocals
	 * @author Tobias Hess
	 * @since 11.07.2017
	 * @return
	 * 		{@link Alphabet} containing only vocals
	 */
	public static Alphabet getAlphabetVocals() {
		return new Alphabet(AlphabetConstants.ALPHABET_VOCALS);
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Alphabet o) {
		return getLetters().compareTo(o.getLetters());
	}
}
