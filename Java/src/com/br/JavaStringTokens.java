package com.br;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaStringTokens {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		// Write your code here.
		LinkedList<String> list = new LinkedList<String>();

		int i = 0;
		Pattern pattern = Pattern.compile("[A-Za-z\b]+");
		Matcher matcher = pattern.matcher(s);
		while (matcher.find()) {
			list.add(matcher.group());
			i++;

		}
		System.out.println(i);
		for (String string : list) {
			System.out.println(string);
		}
		scan.close();
	}
}
