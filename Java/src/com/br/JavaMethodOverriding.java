package com.br;

//Write your overridden getNumberOfTeamMembers method here
class Sports {
	String getName() {
		return "Generic Sports";
	}

	void getNumberOfTeamMembers() {
		System.out.println("Each team has n players in " + getName());
	}
}

class Soccer extends Sports {
	@Override
	String getName() {
		return "Soccer Class";
	}

	// Write your overridden getNumberOfTeamMembers method here
	@Override
	void getNumberOfTeamMembers() {
		System.out.println("Each team has 11 players in " + getName());
	}
}

public class JavaMethodOverriding {

	public static void main(String[] args) {
		Sports C1 = new Sports();
		Soccer C2 = new Soccer();
		System.out.println(C1.getName());
		C1.getNumberOfTeamMembers();
		System.out.println(C2.getName());
		C2.getNumberOfTeamMembers();
	}
}
