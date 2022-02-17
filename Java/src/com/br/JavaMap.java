package com.br;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class JavaMap {

	StringTokenizer stringTokenizer;
	BufferedReader bufferedReader;
	PrintWriter printWriter;

	public static void main(String[] args) throws NumberFormatException, IOException {
		final JavaMap javaMap = new JavaMap();
		long longTime = System.currentTimeMillis();
		javaMap.open();
		javaMap.solve();
		javaMap.close();
	}

	public void open() throws IOException {
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		printWriter = new PrintWriter(new OutputStreamWriter(System.out));
	}

	boolean hasMoreTokens() throws IOException {
		while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
			String line = bufferedReader.readLine();
			if (line == null)
				return false;
			stringTokenizer = new StringTokenizer(line);
		}
		return true;
	}

	public String nextToken() throws IOException {
		while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
			String line = bufferedReader.readLine();
			if (line == null)
				return null;
			stringTokenizer = new StringTokenizer(line);
		}
		return stringTokenizer.nextToken();
	}

	public int nextInt() throws NumberFormatException, IOException {
		return Integer.parseInt(nextToken());
	}

	public long nextLong() throws NumberFormatException, IOException {
		return Long.parseLong(nextToken());
	}

	public double nextDouble() throws NumberFormatException, IOException {
		return Double.parseDouble(nextToken());
	}

	boolean between(final BigInteger n, long from, long to) {
		return n.compareTo(BigInteger.valueOf(from)) > -1 && n.compareTo(BigInteger.valueOf(to)) < 1;
	}

	public void solve() throws NumberFormatException, IOException {
		final Map<String, String> map = new HashMap<>();

		final int n = nextInt();
		for (int i = 0; i < n; i++)
			map.put(bufferedReader.readLine(), bufferedReader.readLine());

		String s;
		while ((s = bufferedReader.readLine()) != null) {
			final String result = map.get(s);
			printWriter.println(result == null ? "Not found" : s + "=" + result);
		}
	}

	public void close() {
		printWriter.flush();
		printWriter.close();
	}
}
