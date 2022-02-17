package com.br;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaList {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner key = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();
		int size = key.nextInt();
		for (int i = 0; i < size; i++) {
			list.add(key.nextInt());
		}
		int numqueries = key.nextInt();
		int index, num;
		String query = "";
		for (int i = 0; i < numqueries; i++) {
			query = key.next();
			if (query.equals("Insert")) {
				// index = key.nextInt();
				list.add(key.nextInt(), key.nextInt());
			} else if (query.equals("Delete")) {
				list.remove(key.nextInt());
			}
		}
		for (Integer i : list) {
			System.out.print(i + " ");
		}
	}
}
