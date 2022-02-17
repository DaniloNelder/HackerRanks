package com.br;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

public class JavaReflectionAttributes {

	public static void main(String[] args) {
		Class student = Student.class;
		Method[] methods = new Method[student.getDeclaredMethods().length];

		ArrayList<String> methodList = new ArrayList<>();
		for (Method name : student.getDeclaredMethods()) {
			methodList.add(name.getName());
		}
		Collections.sort(methodList);
		for (String name : methodList) {
			System.out.println(name);
		}
	}
}
