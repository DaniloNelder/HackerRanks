package com.br;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class JavaCurrencyFormatter {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double payment = scanner.nextDouble();
		scanner.close();

		// Write your code here.
		Locale indiaLocale = new Locale("en", "IN");

		NumberFormat nus = NumberFormat.getCurrencyInstance(Locale.US);
		NumberFormat nindia = NumberFormat.getCurrencyInstance(indiaLocale);
		NumberFormat nchina = NumberFormat.getCurrencyInstance(Locale.CHINA);
		NumberFormat nfrance = NumberFormat.getCurrencyInstance(Locale.FRANCE);

		String us = nus.format(payment);
		String india = nindia.format(payment);
		String china = nchina.format(payment);
		String france = nfrance.format(payment);
		System.out.println("US: " + us);
		System.out.println("India: " + india);
		System.out.println("China: " + china);
		System.out.println("France: " + france);

	}
}
