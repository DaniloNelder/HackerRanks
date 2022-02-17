package com.br;

import java.util.Scanner;

public class JavaStaticInitializerBlock {

	static Scanner sc = new Scanner(System.in);
	static int B = sc.nextInt();
	static int H = sc.nextInt();
	static boolean flag = B > 0 && H > 0;

	static {
		try {
			if (B <= 0 | H <= 0) {
				flag = false;
				throw new Exception();
			} else
				flag = true;
		} catch (Exception ex) {
			System.out.println(ex + ": Breadth and height must be positive");
		}

	}

	public static void main(String[] args) {
		if (flag) {
			int area = B * H;
			System.out.print(area);
		}

	}// end of main

}// end of class
