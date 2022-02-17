package com.br;

public class JavaSingletonPattern {

	public String str;
	private static JavaSingletonPattern obj = new JavaSingletonPattern();

	private JavaSingletonPattern() {

	}

	public static JavaSingletonPattern getSingleInstance() {
		return obj;
	}
}
