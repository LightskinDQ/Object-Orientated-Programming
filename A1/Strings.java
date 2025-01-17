package cp213;

/**
 * @author Your name and id here
 * @version 2023-05-23
 */
public class Strings {
    // Constants
    public static final String VOWELS = "aeiouAEIOU";

    /**
     * Determines if string is a "palindrome": a word, verse, or sentence (such as
     * "Able was I ere I saw Elba") that reads the same backward or forward. Ignores
     * case, spaces, digits, and punctuation in the string parameter s.
     *
     * @param string a string
     * @return true if string is a palindrome, false otherwise
     */
    public static boolean isPalindrome(final String string) {
    	String reverse = "";
    	boolean palidrome = false;
    	
    	for (int i = string.length() - 1; i >= 0; i--) {
            reverse = reverse + string.charAt(i);
        }// for loop
    	
    	if (string.equals(reverse)) {
    		palidrome = true;
    	}


	return palidrome;
    }

    /**
     * Determines if name is a valid Java variable name. Variables names must start
     * with a letter or an underscore, but cannot be an underscore alone. The rest
     * of the variable name may consist of letters, numbers and underscores.
     *
     * @param name a string to test as a Java variable name
     * @return true if name is a valid Java variable name, false otherwise
     */
    public static boolean isValid(final String name) {
    	boolean valid = true;
    	String num = "1234567890";
    	String character = "_";

    	if (num.contains(name.substring(0, 1))) {
    	    valid = false;
    	}//if number 1

    	if (character.contains(name.substring(0, 1))) {
    	    if (name.length() == 1) {
    		valid = false;
    	    }//if number 3
    	}//if number 2
    	
	return valid;
    }

    /**
     * Converts a word to Pig Latin. The conversion is:
     * <ul>
     * <li>if a word begins with a vowel, add "way" to the end of the word.</li>
     * <li>if the word begins with consonants, move the leading consonants to the
     * end of the word and add "ay" to the end of that. "y" is treated as a
     * consonant if it is the first character in the word, and as a vowel for
     * anywhere else in the word.</li>
     * </ul>
     * Preserve the case of the word - i.e. if the first character of word is
     * upper-case, then the new first character should also be upper case.
     *
     * @param word The string to convert to Pig Latin
     * @return the Pig Latin version of word
     */
    public static String pigLatin(String word) {
    	String pigLatin = "";
    	String firstLetter = "";
    	String lowerCase = "abcdefghijklmnopqrstuvwxyz";
    	String pigFirst = "";
    	
    	if (VOWELS.indexOf(word.charAt(0)) != -1) {
    		pigLatin = word + "way";
    	}//if number 1
    	
    	else {
    		firstLetter = Character.toString(word.charAt(0));
    		if (lowerCase.indexOf(firstLetter.charAt(0)) == -1) {
    			firstLetter = firstLetter.toLowerCase();
    			pigFirst = Character.toString(word.charAt(1));
    			pigFirst = pigFirst.toUpperCase();
    			pigLatin = pigFirst + word.substring(2, word.length()) + firstLetter + "ay";
    		}//if number 2
    		
    		else {
    			pigLatin = word.substring(1, word.length()) + firstLetter + "ay";
    		}//else number 2
    	}//else number 1
	return pigLatin;

    }

}
