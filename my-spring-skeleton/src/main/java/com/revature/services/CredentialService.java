package com.revature.services;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.credential.Credentials;
import com.revature.model.Customer;
import com.revature.repos.CredentialsRepo;

@Service
public class CredentialService {

	@Autowired
	CredentialsRepo cr;
	
	@Autowired
	CustomerService cs;
	
    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 256;

    public static byte[] hash(char[] password, byte[] salt) {
        PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
        Arrays.fill(password, Character.MIN_VALUE);
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return skf.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
        } finally {
            spec.clearPassword();
        }
    }
    
    public static String generateSecurePassword(String password, String salt) {
        String returnValue = null;
        byte[] securePassword = hash(password.toCharArray(), salt.getBytes());
        returnValue = Base64.getEncoder().encodeToString(securePassword);
        return returnValue;
    }
    
    public static boolean verifyUserPassword(String providedPassword,
            String securedPassword, String salt) {
        boolean returnValue = false;
        // Generate New secure password with the same salt
        String newSecurePassword = generateSecurePassword(providedPassword, salt);
        // Check if two passwords are equal
        returnValue = newSecurePassword.equalsIgnoreCase(securedPassword);
        return returnValue;
    }
    
	public int save(Credentials c) {
        String password = c.getPassword();
        // Generate Salt. The generated value can be stored in DB. 
        String salt = c.getUsername();
        // Protect user's password. The generated value can be stored in DB.
        String hashedPassword = generateSecurePassword(password, salt);
		Credentials cred = new Credentials();
		cred.setUsername(c.getUsername());
		cred.setPassword(hashedPassword);
		cred.setRole("Customer");
		int credId = cr.save(cred).getId();
		Customer customer = c.getCustomer();
		customer.setId(credId);
		return cs.save(customer);
	}
	
	public List<Credentials> findByUsernameAndPassword(String username, String password) {
        // Salt value stored in database 
        String salt = username;
        String hashedPassword = generateSecurePassword(password, salt);
		return cr.findByUsernameAndPassword(username, hashedPassword);
	}
	
}
