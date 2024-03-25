/*

 * VigenereCipherTest

 * Student Name: Sansita Pattnaik

 * Student Number: 041094310

 * Course: CST8132 Object Oriented Programming

 * Program: CET-CS-Level 2

 * Professor: Daniel Cormier

 *

 */
package testing;

import static org.junit.Assert.assertEquals;
import encryption.ciphers.VigenereCipher;
import org.junit.Test;

/**
 * VigenereCipherTest is a test class to validate the functionality of the VigenereCipher class.
 */

public class VigenereCipherTest {
	
	/**
	 * Author:Sansita Pattnaik
     * Test case to check the encryption functionality of the VigenereCipher class.
     * It encrypts the text "HELLO" using a Vigenere cipher with the key "KEY".
     * The expected result is "sj*wt".
     */ 
	@Test
	public void test1() {
        VigenereCipher v = new VigenereCipher("KEY");
        String encrypted = v.encrypt("HELLO");
        assertEquals("sj*wt", encrypted);
    }

	/**
	 * Author:Sansita Pattnaik
     * Test case to check the encryption functionality of the VigenereCipher class.
     * It encrypts the text "in a land far far away" using a Vigenere cipher with the key "test".
     * The expected result is "bXsZtVYg]e^Zke^ZkeYpZc".
     */
    @Test
    public void test2() {
        VigenereCipher v = new VigenereCipher("test");
        String encrypted = v.encrypt("in a land far far away");
        assertEquals("bXsZtVYg]e^Zke^ZkeYpZc", encrypted);
    }

    /**
     * Author:Sansita Pattnaik
     * Test case to check the decryption functionality of the VigenereCipher class.
     * It decrypts the text "sj*wt" using a Vigenere cipher with the key "KEY".
     * The expected result is "HELLO".
     */
    @Test
    public void test3() {
        VigenereCipher v = new VigenereCipher("KEY");
        String decrypted = v.decrypt("sj*wt");
        assertEquals("HELLO" , decrypted);
    }

    /**
     * Author:Sansita Pattnaik
     * Test case to check the decryption functionality of the VigenereCipher class.
     * It decrypts the text "bXsZtVYg]e^Zke^ZkeYpZc" using a Vigenere cipher with the key "test".
     * The expected result is "in a land far far away".
     */
    @Test
    public void test4() {
        VigenereCipher v = new VigenereCipher("test");
        String decrypted = v.decrypt("bXsZtVYg]e^Zke^ZkeYpZc");
        assertEquals("in a land far far away", decrypted);
    }
}
