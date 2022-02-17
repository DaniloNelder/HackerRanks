package com.br;

import java.util.Scanner;
import java.util.Stack;

public class JavaStack {

	public static void main(String[] argh) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			String input = sc.next();
			// Complete the code
			Stack<Character> s = new Stack<>();
			for (char c : input.toCharArray()) {
				if (c == '(' || c == '{' || c == '[') {
					s.push(c);
					continue;
				}
				if (c == ')' && !s.isEmpty() && s.peek() == '(') {
					s.pop();
					continue;
				}
				if (c == '}' && !s.isEmpty() && s.peek() == '{') {
					s.pop();
					continue;
				}
				if (c == ']' && !s.isEmpty() && s.peek() == '[') {
					s.pop();
					continue;
				}
				if (c == '}' || c == ')' || c == ']') {
					s.push(c);
					break;
				}
			}
			System.out.println(s.isEmpty());
		}
	}

}
