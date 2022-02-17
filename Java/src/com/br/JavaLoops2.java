package com.br;

import java.util.Scanner;

public class JavaLoops2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; ++t) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int n = sc.nextInt();
			int s = a;
			for (int i = 0; i < n; ++i) {
				s += Math.pow(2, i) * b;
				System.out.print(s + " ");
			}
			System.out.print("\n");
		}
	}
}
