package com.br;

import java.util.Arrays;
import java.util.Scanner;

public class JavaSubArray {

	public static void main(String[] args) {

		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner in = new Scanner(System.in);
		int a = Integer.parseInt(in.nextLine());
		String input[] = in.nextLine().split(" ");
		int[] array = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
		System.out.println(countNegativeSubArrays(array));
	}

	public static int countNegativeSubArrays(int[] array) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j < array.length; j++) {
				int[] subarray = Arrays.copyOfRange(array, i, j + 1);
				if (Arrays.stream(subarray).sum() < 0)
					count++;
			}
		}
		return count;
	}

}
