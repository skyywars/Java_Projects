/*

 * Alltest

 * Student Name: Sansita Pattnaik

 * Student Number: 041094310

 * Course: CST8132 Object Oriented Programmings

 * Program: CET-CS-Level 2

 * Professor: Daniel Cormier

 *

 */ 
package testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CaesarCipherTest.class, VigenereCipherTest.class })
public class AllTests {

}
