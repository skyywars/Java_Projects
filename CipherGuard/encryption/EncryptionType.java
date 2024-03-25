/*

 * EncryptionType

 * Student Name: Sansita Pattnaik

 * Student Number: 041094310

 * Course: CST8132 Object Oriented Programming

 * Program: CET-CS-Level 2

 * Professor: Daniel Cormier

 *

 */
package encryption;

import encryption.ciphers.CaesarCipher;
import encryption.ciphers.VigenereCipher;


public abstract class EncryptionType {

	protected final static int START_CHAR=32;
	protected final static int END_CHAR=122;
	protected final static int RANGE=END_CHAR - START_CHAR + 1;

	
	public abstract String encrypt(String text);
	public abstract String decrypt(String text);
	
    public static EncryptionType getMethod() {
        System.out.println("Encryption method");
      

        int choice = ScannerUtils.getMenuItem("Caesar", "Vigenere");

        if (choice == 1) {
            int shift = ScannerUtils.getInt("Shift value: ",1, Integer.MAX_VALUE);
            return new CaesarCipher(shift);
        }
        	else {
            String password = ScannerUtils.getString("Password ");
            return new VigenereCipher(password);
        }
    }
    
    protected char shiftChar1(char c, int offset) {
        int shifted = (int)c + offset;
        /*
        if (shifted < START_CHAR) {
            shifted += RANGE;
        } else if (shifted > END_CHAR) {
            shifted -= RANGE;
        }
		*/
        return (char) shifted;
    }

    public static char shiftChar(char character, int offset) {
    	int ch = (int) character;
        int shifted = ch + offset;

        if (shifted < START_CHAR) {
            shifted += RANGE;
        } 
        	else if (shifted > END_CHAR) {
            shifted -= RANGE;
        }
        return (char) shifted;
    }
}