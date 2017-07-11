package de.framersoft.common.password.generator;

import java.security.InvalidParameterException;

import de.framersoft.common.constants.AlphabetConstants;
import de.framersoft.common.password.alphabet.Alphabet;

/**
 * class for password generation
 * @author Tobias Hess
 * @since 11.07.2017
 */
public class PasswordGenerator {
	
	/**
	 * length of the prefix 
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	private int lengthPrefix = 0;

	/**
	 * length of the postfix
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	private int lengthPostfix = 0;
	
	/**
	 *length of the password
	 *@author Tobias Hess
	 *@since 11.07.2017
	 */
	private int length;
	
	/**
	 * the alphabet of the prefix
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	private Alphabet alphabetPrefix;
	
	/**
	 * the alphabet of the postfix
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	private Alphabet alphabetPostfix;
	
	/**
	 * the alphabet of the password
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	private Alphabet alphabet;
	
	/**
	 * create a speaking password?
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	private boolean speakingPassword = true;

	/**
	 * constructor
	 * @author Tobias Hess
	 * @since 11.07.2017
	 * @param a
	 * 		the alphabet that will be used by the password
	 * @param length
	 * 		the length of the password
	 */
	public PasswordGenerator(Alphabet a, int length) {
		setAlphabet(a);
		setLength(length);
	}
	
	/**
	 * constructor
	 * @author Tobias Hess
	 * @since 11.07.2017
	 * @param letters
	 * 		the letters as string that will be used by the password
	 * @param length
	 * 		the length of the password
	 */
	public PasswordGenerator(String letters, int length) {
		setAlphabet(new Alphabet(letters));
		setLength(length);
	}
	
	/**
	 * generates a password
	 * @author Tobias Hess
	 * @since 11.07.2017
	 * @throws IllegalStateException
	 * 		gets thrown if the prefix and postfix length are bigger than password length.
	 * @throws InvalidParameterException
	 * 		gets thrown if a section with length > 0 has no alphabet
	 * @return
	 * 		the generated password
	 */
	public String generatePassword() {
		//check if prefix and postfix length are bigger than password length
		if(getMainSectionLength() <= 0) {
			throw new IllegalStateException("prefixLength  + postfixLength > passwordLength");
		}
		
		char lastChar = 'B';
		String prefix = generatePasswordSection(getAlphabetPrefix(), getLengthPrefix(), lastChar);
		
		if(prefix.length() > 0) {
			lastChar = prefix.charAt(prefix.length() - 1);
		}
		String main = generatePasswordSection(getAlphabet(), getMainSectionLength(), lastChar);
		
		if(main.length() > 0) {
			lastChar = main.charAt(main.length() - 1);
		}
		String postfix = generatePasswordSection(getAlphabetPostfix(), getLengthPostfix(), lastChar);
		
		return prefix + main + postfix;
	}
	
	/**
	 * generates a section of the password
	 * @author Tobias Hess
	 * @since 11.07.2017
	 * @param a
	 * 		the alphabet that is used in the section
	 * @param length
	 * 		the length of the section
	 * @throws InvalidParameterException
	 * 		gets thrown if the alphabet is null.
	 * @return
	 * 		the generated password section
	 */
	private String generatePasswordSection(Alphabet a, int length, char lastChar) {
		//zero length?
		if(length <= 0) return "";
		//no alphabet?
		if(a == null) throw new InvalidParameterException();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < length; i++) {
			char c;
			
			if(isSpeakingPassword() && a.isSpeakingAlphabet()) {
				if(sb.length() > 0) {
	                lastChar = sb.charAt(sb.length() - 1);
				}

				if(Alphabet.getAlphabetConsonants().isLetterInAlphabet(lastChar)) {
   					c = a.getRandomVocal();
   				}
   				else {
   					c = a.getRandomConsonant();
   				}
			}
			else {
				c = a.getRandomLetter();
			}
			
			sb.append(c);
		}
		
		return sb.toString();
	}
	
	/**
	 * @author Tobias Hess
	 * @since 11.07.2017
	 * @return
	 * 		the length of the main section of the password
	 */
	private int getMainSectionLength() {
		return getLength() - (getLengthPostfix() + getLengthPrefix());
	}
	
	/**
	 * @author Tobias Hess
	 * @since 11.07.2017
	 * @return 
	 * 		the length of the prefix
	 */
	public int getLengthPrefix() {
		return lengthPrefix;
	}

	/**
	 * @author Tobias Hess
	 * @since 11.07.2017
	 * @return 
	 * 		the length of the postfix
	 */
	public int getLengthPostfix() {
		return lengthPostfix;
	}

	/**
	 * @author Tobias Hess
	 * @since 11.07.2017
	 * @return 
	 * 		the length of the password
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @author Tobias Hess
	 * @since 11.07.2017
	 * @return 
	 * 		the alphabet that is used in the prefix
	 */
	public Alphabet getAlphabetPrefix() {
		return alphabetPrefix;
	}

	/**
	 * @author Tobias Hess
	 * @since 11.07.2017
	 * @return 
	 * 		the alphabet that is used in the postfix
	 */
	public Alphabet getAlphabetPostfix() {
		return alphabetPostfix;
	}

	/**
	 * @author Tobias Hess
	 * @since 11.07.2017
	 * @return 
	 * 		the alphabet used by the password
	 */
	public Alphabet getAlphabet() {
		return alphabet;
	}

	/**
	 * @author Tobias Hess
	 * @since 11.07.2017
	 * @return 
	 * 		will a speaking password be generated?
	 */
	public boolean isSpeakingPassword() {
		return speakingPassword;
	}
	
	/**
	 * @author Tobias Hess
	 * @since 11.07.2017
	 * @param lengthPrefix 
	 * 		the length of the prefix
	 * @throws InvalidParameterException
	 * 		gets thrown if the given length < 0
	 */
	public void setLengthPrefix(int lengthPrefix) {
		if(lengthPrefix < 0) {
			throw new InvalidParameterException("prefix length cant be less then 0");
		}
		
		this.lengthPrefix = lengthPrefix;
	}

	/**
	 * @author Tobias Hess
	 * @since 11.07.2017
	 * @param lengthPostfix 
	 * 		the length of the postfix
	 * @throws InvalidParameterException
	 * 		gets thrown if the given length < 0
	 */
	public void setLengthPostfix(int lengthPostfix) {
		if(lengthPostfix < 0) {
			throw new InvalidParameterException("postfix length cant be less then 0");
		}
		
		this.lengthPostfix = lengthPostfix;
	}

	/**
	 * @author Tobias Hess
	 * @since 11.07.2017
	 * @param alphabetPrefix 
	 * 		the alphabet that shall be used in the prefix
	 */
	public void setAlphabetPrefix(Alphabet alphabetPrefix) {
		this.alphabetPrefix = alphabetPrefix;
	}

	/**
	 * @author Tobias Hess
	 * @since 11.07.2017
	 * @param alphabetPostfix 
	 * 		the alphabet that shall be used in the postfix
	 */
	public void setAlphabetPostfix(Alphabet alphabetPostfix) {
		this.alphabetPostfix = alphabetPostfix;
	}

	/**
	 * @author Tobias Hess
	 * @since 11.07.2017
	 * @param speakingPassword 
	 * 		true if a speaking password shall be generated, false otherwise
	 */
	public void setSpeakingPassword(boolean speakingPassword) {
		this.speakingPassword = speakingPassword;
	}

	/**
	 * @author Tobias Hess
	 * @since 11.07.2017
	 * @param length 
	 * 		the length of the password
	 * @throws InvalidParameterException
	 * 		gets thrown if the given length <= 3
	 */
	private void setLength(int length) {
		if(length <= 3) {
			throw new InvalidParameterException("password length should be at least 4");
		}
		
		this.length = length;
	}

	/**
	 * @author Tobias Hess
	 * @since 11.07.2017
	 * @param alphabet 
	 * 		the alphabet the password will use
	 */
	private void setAlphabet(Alphabet alphabet) {
		this.alphabet = alphabet;
	}
	
	/**
	 * creates a {@link PasswordGenerator} instance to
	 * generate Internet Passwords with
	 * @author Tobias Hess
	 * @since 11.07.2017
	 * @param length
	 * 		length of the passwords to generate with the generator
	 * @return
	 * 		{@link PasswordGenerator} instance
	 */
	public static PasswordGenerator getInternetPasswordGenerator(int length) {
		PasswordGenerator pg = new PasswordGenerator("abdefghiklmoprstu", length);
		pg.setLengthPrefix(1);
		pg.setAlphabetPrefix(new Alphabet("ABDEFGHIKLMNOPRSTU"));
		pg.setLengthPostfix(3);
		pg.setAlphabetPostfix(new Alphabet(AlphabetConstants.ALPHABET_NUMBERS));
		pg.setSpeakingPassword(true);
		
		return pg;
	}
}
