package com.br;

import java.util.BitSet;
import java.util.Scanner;

public class JavaBitSet {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		BitSet b1 = new BitSet(n);
		BitSet b2 = new BitSet(n);
		scan.nextLine();
		for (int i = 0; i < m; i++) {
			String in = scan.nextLine();
			String[] arr = in.split("\\s+");
			String op = arr[0];
			int first = Integer.parseInt(arr[1]);
			int second = Integer.parseInt(arr[2]);
			BitSet r = (first == 1) ? b1 : b2;
			if (op.equals("AND")) {
				BitSet s = (second == 1) ? b1 : b2;
				r.and(s);
			} else if (op.equals("OR")) {
				BitSet s = (second == 1) ? b1 : b2;
				r.or(s);
			} else if (op.equals("XOR")) {
				BitSet s = (second == 1) ? b1 : b2;
				r.xor(s);
			} else if (op.equals("FLIP")) {
				r.flip(second);
			} else {
				r.set(second);
			}
			System.out.print(b1.cardinality());
			System.out.print(" ");
			System.out.println(b2.cardinality());
		}
	}
}
