package postalCode; 

import java.security.SecureRandom;

/**
 * Class representing one entry/row in CSV file of Canadian postal codes.
 * 
 * @author [Your Name]
 * @version 1.0
 */
public class PostalCodeEntry {
	 /**The first portion of the postal code*/
    private String prefix;

    /** The name of the place corresponding to the postal code*/
    private String placeName;

    /**The province where the place is located*/
    private String province;

    /** The latitude of the centre of the postal code*/
    private String latitude;

    /**The longitude of the centre of the postal code*/
    private String longitude;

    /**
     * Constructor to initialize the PostalCodeEntry.
     * 
     * @param prefix     the first portion of the postal code
     * @param placeName  name of the place corresponding to the postal code
     * @param province   province where the place is located
     * @param latitude   latitude of the centre of the postal code
     * @param longitude  longitude of the centre of the postal code
     */
    public PostalCodeEntry(String prefix, String placeName, String province, String latitude, String longitude) {
        this.prefix = prefix;
        this.placeName = placeName;
        this.province = province;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * No-argument constructor set all instance variables to null.
     */
    public PostalCodeEntry() {
    }

    /**
     * Constructor that uses an array to initialize the PostalCodeEntry.
     * 
     * @param fields array of String corresponding to: prefix, placeName, province, latitude, longitude
     */
    public PostalCodeEntry(String[] fields) {
        this(fields[0], fields[1], fields[2], fields[3], fields[4]);
    }

    /**
     * Gets the prefix of the postal code.
     * 
     * @return the first portion of the postal code
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * Returns a string representation of the PostalCodeEntry.
     * 
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s, %s", prefix, placeName, province, latitude, longitude);
    }

    /**
     * Generates a random prefix using the correct format for Canadian postal codes.
     * 
     * @return randomly generated prefix of the postal code
     */
    public static String getRandomPrefix() {
        final SecureRandom rand = new SecureRandom();
        final String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String number = "0123456789";
        int randA = rand.nextInt(alpha.length());
        int randN = rand.nextInt(number.length());
        return "K" + number.charAt(randN) + alpha.charAt(randA);
    }
}
