/*

 * lab6test

 * Student Name: Sansita Pattnaik

 * Student Number: 041094310

 * Course: CST8132 Object Oriented Programming

 * Program: CET-CS-Level 2

 * Professor: Daniel Cormier

 *

 */
import java.util.ArrayList;
import java.util.List;
import encryption.ScannerUtils;
import encryption.EncryptionType;

/**
 * Author:Sansita Pattnaik
 * Lab6Test class is a tester for text encryption and decryption using different encryption methods.
 */
public class Lab6Test {
	  	private static final String[] MENU_OPTIONS = {"Encrypt text", "Decrypt text", "Display encrypted list", "Exit"};
	    private List<String> encryptedText;
	    private EncryptionType encryptionMethod;

	    /**
	     * Author:Sansita Pattnaik
	     * Constructor for Lab6Test class. Initializes the encryptedText list.
	     */
	    public Lab6Test() {
	        encryptedText = new ArrayList<>();
	         
	    }	    
	   
	    /**
	     * Author:Sansita Pattnaik
	     * Runs the tester for text encryption and decryption.
	     * This method presents a menu to the user and performs corresponding actions based on user's choice.
	     */
	    //Runs the tester
	    public void run() {
	    	
	        System.out.println("Encrption tester");
	        encryptedText = new ArrayList<>();

	        while (true) {
	        	int choice = ScannerUtils.getMenuItem(MENU_OPTIONS);

	            switch (choice) {
	                case 1:
	                    String textToEncrypt = ScannerUtils.getString("Enter the text to be encrypted");
	                    encryptionMethod = EncryptionType.getMethod();
	                    
	                    String encrypted = encryptionMethod.encrypt(textToEncrypt);
	                    encryptedText.add(encrypted);
	                    
	                    System.out.println("Encrypted value #"+encryptedText.size()+" is: "+ encrypted);
	                    break;
	                    
	                case 2:
	                    if (encryptedText.isEmpty()) {
	                        System.out.println("Nothing to decrypt");
	                        continue;
	                    }
	                    int textIndex = ScannerUtils.getInt("\nMessage number you want to decrypt",1,encryptedText.size());
	                    
	                  
	                   
	                    encryptionMethod = EncryptionType.getMethod();
	                    String decrypted = encryptionMethod.decrypt(encryptedText.get(textIndex - 1));
	                    System.out.println("Decrypted text #"+textIndex+" is: " + decrypted);
	                    break;
	                    
	                case 3:
	                	if(encryptedText.isEmpty()) {
	                		System.out.println("Nothing to display");
	                		System.out.println();
	                		continue;
	                	}
	                	System.out.println("------------------------");
	                    for (int i = 0; i < encryptedText.size(); i++) {
	                        System.out.printf("#%d: %s%n", i + 1, encryptedText.get(i));
	                    }
	                    System.out.println("------------------------");
	                    break;
	                    
	                case 4:
	                    System.out.println("Good bye");
	                    return;
	            }
	        }
	    }

	    
	    /**
	     * Author:Sansita Pattnaik
	     * Main method to start the program.
	     *
	     * @param args Command line arguments (unused).
	     */
	   
	    public static void main(String[] args) {
	        Lab6Test lab6Test = new Lab6Test();
	        lab6Test.run();
	    }
	}
	
	

