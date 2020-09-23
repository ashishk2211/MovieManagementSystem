package com.cg.ocaprep;
enum Animals
{
	Dog("bark"),Fish("barble"),cat("meow");
	String sound;
	Animals(String s)
	{
		sound=s;
	}
}
class TestEnum {
	static Animals a;
	public static void main(String[] args) {
		
		System.out.println(a.Dog.sound+" "+a.Fish.sound);
		

	}

}
