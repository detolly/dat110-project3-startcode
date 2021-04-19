package no.hvl.dat110.util;

/**
 * project 3
 *
 * @author tdoy
 */

import javax.xml.bind.DatatypeConverter;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

	private static BigInteger hashint;

	public static BigInteger hashOf(String entity) {

		// Task: Hash a given string using MD5 and return the result as a BigInteger.

		// we use MD5 with 128 bits digest

		// compute the hash of the input 'entity'

		// convert the hash into hex format

		// convert the hex into BigInteger

		// return the BigInteger

		MessageDigest md;

		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}

		return (hashint = new BigInteger(toHex(md.digest(entity.getBytes(StandardCharsets.UTF_8))), 16));
	}

	public static BigInteger addressSize() {

		// Task: compute the address size of MD5

		// get the digest length

		// compute the number of bits = digest length * 8

		// compute the address size = 2 ^ number of bits

		// return the address size
		return BigInteger.valueOf(2L).pow(bitSize());
	}

	public static int bitSize() {
		// find the digest length
		String hex = String.format("%32s", hashint.toString(16)).replaceAll(" ", "0");
		return DatatypeConverter.parseHexBinary(hex).length * 8;
	}

	public static String toHex(byte[] digest) {
		StringBuilder strBuilder = new StringBuilder();
		for (byte b : digest) {
			strBuilder.append(String.format("%02x", b & 0xff));
		}
		return strBuilder.toString();
	}

}