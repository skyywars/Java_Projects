/*

 * CaesarCipherTest

 * Student Name: Sansita Pattnaik

 * Student Number: 041094310

 * Course: CST8132 Object Oriented Programming

 * Program: CET-CS-Level 2

 * Professor: Daniel

 *

 */
package testing;

import  org.junit.Test;
import static org.junit.Assert.assertEquals;
import encryption.ciphers.CaesarCipher;

/**
 * Author:Sansita Pattnaik
 * CaesarCipherTest is a test class to validate the functionality of the CaesarCipher class.
 */

public class CaesarCipherTest {

	/**
	 * Author:Sansita Pattnaik
     * Test case to check the encryption functionality of the CaesarCipher class with a positive shift.
     * It encrypts the text "Once upon a time..." using a Caesar cipher with a shift of 5.
     * The expected result is "Tshj%zuts%f%ynrj333".
     */
	@Test
	 public void test1() {
        CaesarCipher c = new CaesarCipher(5);
        String encrypted = c.encrypt("Once upon a time...");
        assertEquals("Tshj%zuts%f%ynrj333", encrypted);
    }

	
	/**
	 * Author:Sansita Pattnaik
     * Test case to check the encryption functionality of the CaesarCipher class with a positive shift.
     * It encrypts the text "sancy" using a Caesar cipher with a shift of 5.
     * The expected result is "xfsh~".
     */
    @Test
   public void test2() {
      CaesarCipher c = new CaesarCipher(5);  
       String encrypted = c.encrypt("sancy");
       assertEquals("xfsh#", encrypted);
  }
   
    /**
     * Author:Sansita Pattnaik
     * Test case to check the decryption functionality of the CaesarCipher class with a positive shift.
     * It decrypts the text "Tshj%zuts%f%ynrj333" using a Caesar cipher with a shift of 5.
     * The expected result is "Once upon a time...".
     */
    @Test
    public void test3() {
        CaesarCipher c = new CaesarCipher(5);
        String decrypted = c.decrypt("Tshj%zuts%f%ynrj333");
        assertEquals("Once upon a time..." , decrypted);
    }

    /**
    * Author:Sansita Pattnaik
    * Test case to check the decryption functionality of the CaesarCipher class with a negative shift.
    * It decrypts the text "o]j_u" using a Caesar cipher with a shift of -4.
    * The expected result is "sancy".
    */
    @Test
    public void test4() {
    	CaesarCipher c = new CaesarCipher(-4);
    	String decrypted = c.decrypt("o]j_u");
        assertEquals("sancy", decrypted);
    }
}