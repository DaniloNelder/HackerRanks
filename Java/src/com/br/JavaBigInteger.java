package com.br;

import java.math.BigInteger;
import java.util.Scanner;

public class JavaBigInteger {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner scan = new Scanner(System.in);
		BigInteger bigIntA = scan.nextBigInteger();
		BigInteger bigIntB = scan.nextBigInteger();
		System.out.println(bigIntA.add(bigIntB).toString());
		System.out.println(bigIntA.multiply(bigIntB).toString());
	}
}
