package com.br;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaStdinAndStdout2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String r[] = new String[3];
		for (int i = 0; i < 3; i++) {
			r[i] = br.readLine();
		}

		System.out.println("String: " + r[2]);
		System.out.println("Double: " + Double.parseDouble(r[1]));
		System.out.println("Int: " + Integer.parseInt(r[0]));
	}
}
