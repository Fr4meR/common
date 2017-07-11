package de.framersoft.common.constants;
/**
 * this interface contains Alphabet constants
 * @author Tobias Hess
 * @since 10.07.2017
 */
public interface AlphabetConstants {
	
	/**
	 * alphabet: A-Z
	 * @author Tobias Hess
	 * @since 10.07.2017
	 */
	public final static String ALPHABET_A_TO_Z_UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	/**
	 * alphabet: a-z
	 * @author Tobias Hess
	 * @since 10.07.2017
	 */
	public final static String ALPHABET_A_TO_Z_LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
	
	/**
	 * alphabet: a-z and A-Z
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	public final static String ALPHABET_A_TO_Z = ALPHABET_A_TO_Z_LOWERCASE + ALPHABET_A_TO_Z_UPPERCASE;
	
	/**
	 * alphabet: containing only consonants
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	public final static String ALPHABET_CONSONANTS = "aeiouAEIOU";
	
	/**
	 * alphabet: containing only vocals
	 * @author Tobias
	 * @since 11.07.2017
	 */
	public final static String ALPHABET_VOCALS = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
	
	/**
	 * alphabet: numbers
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	public final static String ALPHABET_NUMBERS = "0123456789";
	
	/**
	 * alphabet: numbers and characters
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	public final static String ALPHABET_ALPHANUMERIC = ALPHABET_A_TO_Z + ALPHABET_NUMBERS;
	
	/**
	 * alphabet: �, �, �
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	public final static String ALPHABET_UMLAUTE_LOWERCASE = "���";
	
	/**
	 * alphabet: �, �, �
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	public final static String ALPHABET_UMLAUTE_UPPERCASE = "���";
	
	/**
	 * alphabet: �, �, �, �, �, �
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	public final static String ALPHABET_UMLAUTE = ALPHABET_UMLAUTE_LOWERCASE + ALPHABET_UMLAUTE_UPPERCASE;
	
	/**
	 * alphabet containing punctuation characters
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	public final static String ALPHABET_PUNCTUATION = ".,:;-_";
	
	/**
	 * alphaber: special characters
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	public final static String ALPHABET_SPECIAL_CHARACTERS = "!\"�$%&/()=?+#*~'\\}][{";
}
