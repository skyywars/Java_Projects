/*

 * VigenereCipher

 * Student Name: Sansita Pattnaik

 * Student Number: 041094310

 * Course: CST8132 Object Oriented Programming

 * Program: CET-CS-Level 2

 * Professor: Daniel Cormier

 *

 */

package encryption.ciphers;
import encryption.EncryptionType;


/**
 * Author:Sansita Pattnaik
 * The VigenereCipher class implements the Encryptable interface and represents a Vigenere cipher encryption and decryption algorithm.
 */
	public class VigenereCipher extends EncryptionType {
	    private String key;

	    
	    /**
	     * Author:Sansita Pattnaik
	     * Constructs a new VigenereCipher object with the provided encryption key.
	     *
	     * @param password The encryption key to be used.
	     */
	    	
	    //The encryption key is set by the constructor.
	    public VigenereCipher(String password) {
	        key = password;
	        
	    }

	   
	    
	    /**
	     * Author:Sansita Pattnaik
	     * Encrypts the input text using the Vigenere cipher algorithm and returns the encrypted result.
	     *
	     * @param input The text to be encrypted.
	     * @return The encrypted result of the input text.
	     */
	    
	   //Returns the encrypted result after applying the Vigenere cypher algorithm to encrypt the input text.
	    public String encrypt(String input) {
	        StringBuilder E = new StringBuilder();
	        
	        int KL = key.length();
	        int IL = input.length();
	        
	        
	        for (int q = 0; q < IL; q++) { 
	            char c = input.charAt(q); //stores char value of user input 
	            char k = key.charAt(q % KL); //it takes the MOD of the user input in terms of the key given 
	            
	            E.append((char) ( ((int)(shiftChar1(c,(int)k)) - 2 * START_CHAR) % RANGE + START_CHAR));
	     
	        }
	        return E.toString();
	    }

	    /**
	     * Author:Sansita Pattnaik
	     * Decrypts the input text using the Vigenere cipher algorithm and returns the decrypted result.
	     *
	     * @param input The text to be decrypted.
	     * @return The decrypted result of the input text.
	     */
	    
	   // Returns the decrypted text after decrypting the input text using the Vigenere cypher algorithm.
	    public String decrypt(String input) {
	        StringBuilder D = new StringBuilder();
	        int keyLength = key.length();
	        int IL = input.length();
	        
	        // decryption process
	        for (int q = 0; q < IL; q++) {
	            char c = input.charAt(q); //stores char value of user input 
	            char k = key.charAt(q % keyLength); //it takes the MOD of the user input in terms of the key given 
	            D.append((char) ((shiftChar((char)c , -k )+ RANGE) % RANGE + START_CHAR));
	        }
	        return D.toString();
	    }
	}


