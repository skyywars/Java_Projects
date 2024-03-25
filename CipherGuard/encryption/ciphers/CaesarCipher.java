/*

 * CaesarCipher

 * Student Name: Sansita Pattnaik

 * Student Number: 041094310

 * Course: CST8132 Object Oriented Programming

 * Program: CET-CS-Level 2

 * Professor: Daniel Cormier

 *

 */
package encryption.ciphers;

import encryption.EncryptionType;
	

	public class CaesarCipher extends EncryptionType {
	    private final int key;
	  //  private int shift;
	    
	 

	    /**
	     * Constructs a new CaesarCipher object with the provided encryption key (shift value).
	     *
	     * @param shift The encryption key (shift value) to be used.
	     */
	    
	    // The encryption key is set in the constructor (shift value).
	    public CaesarCipher(int shift) {
	        this.key = shift;
	    }

	    
	    

	    /**
	     * Encrypts the input text using the Caesar cipher algorithm and returns the encrypted result.
	     *
	     * @param input The text to be encrypted.
	     * @return The encrypted result of the input text.
	     */
	    
	    // Returns the encrypted result after using the Caesar cypher algorithm to encrypt the input text.
	    public String encrypt(String input) {
	        
	            StringBuilder inputResult = new StringBuilder();
	            
	            //Encryption process
	            for (int q = 0; q < input.length(); q++) {
	                char a = input.charAt(q);
	                
	                int numA=(int)a;
	                int cal = shiftChar(a,key);
	                char encrypChar= (char) cal;
	                
	                inputResult.append(encrypChar);
	            }
	            return inputResult.toString();
	        }
	    
	    /**
	     * Decrypts the input text using the Caesar cipher algorithm and returns the decrypted result.
	     *
	     * @param input The text to be decrypted.
	     * @return The decrypted result of the input text.
	     */
	    
	    //Caesar cypher algorithm is used to decrypt the input text, and the result is returned.
	    public String decrypt(String input) {
	    	StringBuilder inputResult = new StringBuilder();
	    	
	    	//decryption process
            for (int q = 0; q < input.length(); q++) {
                char a = input.charAt(q);
                
                int numA=(int)a;
                int cal = shiftChar(a,-key);
                char decrypChar = (char) cal;
                
                inputResult.append(decrypChar);
            }
            return inputResult.toString();
	    }
	}


