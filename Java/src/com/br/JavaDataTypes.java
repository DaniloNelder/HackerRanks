package com.br;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class JavaDataTypes {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int i = Integer.parseInt(br.readLine());
			for (int j = 0; j < i; j++) {
				String s = br.readLine();
				BigInteger num = new BigInteger(s);
				if (num.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0
						|| num.compareTo(BigInteger.valueOf(Long.MIN_VALUE)) < 0) {
					System.out.println(num + " can't be fitted anywhere.");
				} else {
					System.out.println(num + " can be fitted in:");
					long value = num.longValue();
					findDatatype(value);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void findDatatype(long value) {

		if (value == 0 || value == 1) {
			System.out.println("* boolean");
		}

		if (value >= Byte.MIN_VALUE && value <= Byte.MAX_VALUE) {
			System.out.println("* byte");
		}

		if (value >= Short.MIN_VALUE && value <= Short.MAX_VALUE) {
			System.out.println("* short");
		}

		if (value >= Integer.MIN_VALUE && value <= Integer.MAX_VALUE) {
			System.out.println("* int");
		}

		if (value >= Long.MIN_VALUE && value <= Long.MAX_VALUE) {
			System.out.println("* long");
		}

	}
}
