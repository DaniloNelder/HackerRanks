package com.br;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class JavaDataTypes {
	/*
	 * Java has 8 primitive data types; char, boolean, byte, short, int, long,
	 * float, and double. For this exercise, we'll work with the primitives used to
	 * hold integer values (byte, short, int, and long):
	 * 
	 * A byte is an 8-bit signed integer. A short is a 16-bit signed integer. An int
	 * is a 32-bit signed integer. A long is a 64-bit signed integer. Given an input
	 * integer, you must determine which primitive data types are capable of
	 * properly storing that input.
	 * 
	 * To get you started, a portion of the solution is provided for you in the
	 * editor.
	 * 
	 * Reference:
	 * https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
	 * 
	 * Input Format
	 * 
	 * The first line contains an integer, , denoting the number of test cases. Each
	 * test case, , is comprised of a single line with an integer, , which can be
	 * arbitrarily large or small.
	 * 
	 * Output Format
	 * 
	 * For each input variable and appropriate primitive , you must determine if the
	 * given primitives are capable of storing it. If yes, then print:
	 * 
	 * n can be fitted in: dataType If there is more than one appropriate data type,
	 * print each one on its own line and order them by size (i.e.: ).
	 * 
	 * If the number cannot be stored in one of the four aforementioned primitives,
	 * print the line:
	 * 
	 * n can't be fitted anywhere. Sample Input
	 * 
	 * 5 -150 150000 1500000000 213333333333333333333333333333333333
	 * -100000000000000 Sample Output
	 * 
	 * -150 can be fitted in: short int long 150000 can be fitted in: int long
	 * 1500000000 can be fitted in: int long 213333333333333333333333333333333333
	 * can't be fitted anywhere. -100000000000000 can be fitted in: long Explanation
	 * 
	 * can be stored in a short, an int, or a long.
	 * 
	 * is very large and is outside of the allowable range of values for the
	 * primitive data types discussed in this problem
	 */

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
