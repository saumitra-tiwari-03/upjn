/*==========================================================================
 * Description : EncryptionService class contains the  encryption logic of password any user. 
 * Date:  
 * Author: RAM PRAKASH PANDEY
 * Review By : 
 * Review Date:  
 *==========================================================================
 */

package com.nic.upjn.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Encoder;

public final class EncryptionService {

	private static EncryptionService instance;

	private EncryptionService() {
	}

	public synchronized String encrypt(String plaintext) throws Exception {

		MessageDigest md = null;

		try {

			md = MessageDigest.getInstance("MD5"); // step 2

		} catch (NoSuchAlgorithmException e) {

			throw new Exception(e.getMessage());

		} // end try-catch

		try {

			md.update(plaintext.getBytes("UTF-16")); // step 3
			System.out
					.println("!!!!!!!!!!!!!!=================password====================!!!!!!!!!!!!!!!!!!!!");

		} catch (UnsupportedEncodingException e) {

			throw new Exception(e.getMessage());
		} // end try-catch

		byte raw[] = md.digest(); // step 4
		String hash = (new BASE64Encoder()).encode(raw); // step 5
		return hash; // step 6

	} // end method

	public static synchronized EncryptionService getInstance() { // step 1

		if (instance == null) {

			instance = new EncryptionService();

		} // end if

		return instance;

	} // end method

} // end class

