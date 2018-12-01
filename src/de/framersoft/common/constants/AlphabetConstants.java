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
	 * alphabet: ö, ä, ü
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	public final static String ALPHABET_UMLAUTE_LOWERCASE = "äöü";
	
	/**
	 * alphabet: Ö, Ü, Ä
	 * @author Tobias Hess
	 * @since 11.07.2017
	 */
	public final static String ALPHABET_UMLAUTE_UPPERCASE = "ÄÖÜ";
	
	/**
	 * alphabet: ö, ä, ü, Ö, Ä, Ü
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
	public final static String ALPHABET_SPECIAL_CHARACTERS = "!\"§$%&/()=?+#*~'\\}][{";
	
	/**
	 * alphabet: charecters of a hexadezimal number
	 * @author Tobias Hess
	 * @since 19.07.2017
	 */
	public final static String ALPHABET_HEXADECIMAL_CHARACTERS = "abcdef1234567890";
}
