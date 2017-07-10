package de.framersoft.common.password.alphabet;

import java.security.InvalidParameterException;

/**
 * This class represents an alphabet
 * @author Tobias Hess
 * @since 10.07.2017
 */
public class Alphabet {
	
	/**
	 * the string of letters that is used by the 
	 * alphabet
	 * @author Tobias Hess
	 * @since 10.07.2017
	 */
	private String letters = "";
	
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
}
