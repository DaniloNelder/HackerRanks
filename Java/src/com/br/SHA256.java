package com.br;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class SHA256 {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		Scanner scan = new Scanner(System.in);
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		messageDigest.reset();
		messageDigest.update(scan.nextLine().getBytes());
		for (byte i : messageDigest.digest()) {
			System.out.print(String.format("%02x", i));
		}
		System.out.println();
	}
}
