package com.br;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Scanner;

public class JavaDequeue {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Deque deque = new ArrayDeque<>();
		int n = in.nextInt();
		int m = in.nextInt();

		int max = 0;
		HashMap hp = new HashMap();

		for (int i = 0; i < n; i++) {
			int num = in.nextInt();
			deque.addFirst(num);
			Integer nm = (Integer) hp.get("" + num);
			if (nm == null) {
				hp.put("" + num, new Integer(1));
			} else {
				nm++;
				hp.put("" + num, nm);
			}
			int cnt = 0;
			if (deque.size() == m) {
				int e = (int) deque.removeLast();
				cnt = hp.size();
				if (cnt > max)
					max = cnt;
				Integer mm = (Integer) hp.get("" + e);
				if (mm != null) {
					if (mm.intValue() > 1) {
						mm--;
						hp.put("" + e, mm);
					} else {
						hp.remove("" + e);
					}
				}
			}
		}
		System.out.println(max);
	}
}
