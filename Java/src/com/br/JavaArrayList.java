package com.br;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaArrayList {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int temp = 0;
		List<Integer>[] data = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			temp = sc.nextInt();
			data[i] = new ArrayList<Integer>();
			for (int j = 0; j < temp; j++)
				data[i].add(sc.nextInt());
		}
		int Q = sc.nextInt();
		int[][] qry = new int[Q][2];
		for (int i = 0; i < Q; i++) {
			for (int j = 0; j < 2; j++)
				qry[i][j] = sc.nextInt();
		}
		Integer dataListIndex = 0;
		Integer dataIndex = 0;
		Integer actualData = null;
		for (int i = 0; i < Q; i++) {
			dataListIndex = qry[i][0];
			dataIndex = qry[i][1];
			try {
				actualData = data[dataListIndex - 1].get(dataIndex - 1);
			} catch (Exception e) {
				actualData = null;
			}
			if (actualData != null)
				System.out.println(actualData);
			else
				System.out.println("ERROR!");
		}
	}
}
