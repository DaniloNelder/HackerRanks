package com.br;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JavaExceptionHandlingTryCatch {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner sc = new Scanner(System.in);
		try {
			int x = sc.nextInt();
			int y = sc.nextInt();

			System.out.println("" + x / y);
		} catch (InputMismatchException e1) {
			System.out.println("java.util.InputMismatchException");
		} catch (ArithmeticException e2) {
			System.out.println(e2.toString());
		}
	}
}
