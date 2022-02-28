package Proj0;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

// A Java program that uses the MD5 to do the hashing
public class MD5 {
	public static String getMd5(String input) {
		try {
			MessageDigest msgDst = MessageDigest.getInstance("MD5");
			byte[] msgArr = msgDst.digest(input.getBytes());
			BigInteger bi = new BigInteger(1, msgArr);
			String hshtxt = bi.toString(16);
			while (hshtxt.length() < 32) {
				hshtxt = "0" + hshtxt;
			}
			return hshtxt;
		} catch (NoSuchAlgorithmException abc) {
			throw new RuntimeException(abc);
		}
	}
}