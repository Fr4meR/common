package de.framersoft.common.password.strength;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import de.framersoft.common.constants.AlphabetConstants;
import de.framersoft.common.constants.PasswordStrengthConstants;
import de.framersoft.common.password.alphabet.Alphabet;

/**
 * class with functions for simple password strength estimation
 * @author Tobias Hess
 * @since 11.07.2017
 */
public final class PasswordStrength implements PasswordStrengthConstants{

	/**
	 * calculates a rating for a given password
	 * @author Tobias Hess
	 * @since 11.07.2017
	 * @see PasswordStrengthConstants
	 * @param password
	 * 		the password to calculate a strength rating for
	 * @return
	 * 		an integer representing the password strength
	 */
	public static int calculatePasswordStrengthRating(String password) {
		double crackingTime = calculateCrackTime(password, 5000);
		
		//lower than a week
		if(crackingTime < 60 * 60 * 24 * 7) {
			return PASSWORD_STRENGTH_VERY_WEAK;
		}
		//lower than 3 months
		else if(crackingTime < 60 * 60 * 24 * 30 * 1) {
			return PASSWORD_STRENGTH_WEAK;
		}
		//lower than a year 
		else if(crackingTime < 60 * 60 * 24 * 365) {
			return PASSWORD_STRENGTH_MODERATE;
		}
		//lower than a 10 years
		else if(crackingTime < 60 * 60 * 24 * 365 * 10 ) {
			return PASSWORD_STRENGTH_STRONG;
		}
		else {
			return PASSWORD_STRENGTH_VERY_STRONG;
		}
	}
	
	/**
	 * calculates an estimated crack time for a given password with the given
	 * guesses per second
	 * @author Tobias Hess
	 * @since 11.07.2017
	 * @param password
	 * 		password to calculate the crack time for
	 * @param guessesPerSecond
	 * 		the guesses per second the cracking machine can do
	 * @return
	 * 		the estimated time in seconds the password would need to be cracked 
	 */
	public static double calculateCrackTime(String password, int guessesPerSecond) {
		final double secondsPerGuess = 1D / guessesPerSecond;
		return 0.5 * Math.pow(2, calculateEntropy(password)) * secondsPerGuess; 
	}
	
	/**
	 * calculates the entropy of a password in bits
	 * @author Tobias Hess
	 * @since 11.07.2017
	 * @param password
	 * 		the password to calculate the entropy in bits for
	 * @return
	 * 		the entropy of the password in bits
	 */
	public static double calculateEntropy(String password) {
		final int passwordLength = password.length();
		final int passwordSpace = calculateSpace(password);
		
		return passwordLength * Math.log(passwordSpace);
	}	
	
	/**
	 * calculates the character space of the given password.
	 * character space means the amount of different letters that are possible
	 * in the password.
	 * @author Tobias Hess
	 * @since 11.07.2017
	 * @param password
	 * 		the password to calculate the space for
	 * @return
	 * 		the password space
	 */
	public static int calculateSpace(String password) {
		int passwordSpace = 0;
		
		List<Alphabet> alphabets = new LinkedList<Alphabet>();
		
		alphabets.add(Alphabet.getAlphabetAToZLowerCase());
		alphabets.add(Alphabet.getAlphabetAToZUpperCase());
		alphabets.add(new Alphabet(AlphabetConstants.ALPHABET_NUMBERS));
		alphabets.add(new Alphabet(AlphabetConstants.ALPHABET_UMLAUTE));
		alphabets.add(new Alphabet(AlphabetConstants.ALPHABET_PUNCTUATION));
		alphabets.add(new Alphabet(AlphabetConstants.ALPHABET_SPECIAL_CHARACTERS));
		
		for(int i = 0; i < password.length(); i++) {
			char c = password.charAt(i);
			
			Iterator<Alphabet> iterator = alphabets.iterator();
			while(iterator.hasNext()) {
				Alphabet a = iterator.next();
				if(a.isLetterInAlphabet(c)) {
					passwordSpace += a.getLetters().length();
					iterator.remove();
				}
			}
		}
			
		return passwordSpace;
	}
}
