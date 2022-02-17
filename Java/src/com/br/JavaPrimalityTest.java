package com.br;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class JavaPrimalityTest {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String n = bufferedReader.readLine();
		BigInteger bigInt = new BigInteger(n);
		String message = bigInt.isProbablePrime(100) ? "prime" : "not prime";
		System.out.println(message);
		bufferedReader.close();
	}
}
