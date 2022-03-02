package Proj4;	// if Editor == Sublime: Comment this line

import	java.io.*;
import	java.lang.*;
import	java.util.*;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {
// A Java program that uses the MD5 to do the hashing
	public static String hashMe(String input) {
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
