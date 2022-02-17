package com.br;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaEndofFile {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		Integer count = 1;
		while (true) {
			str = br.readLine();
			if (str == null) {
				break;
			}
			System.out.println(count++ + " " + str);
		}
	}
}
