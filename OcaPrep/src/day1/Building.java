package day1;

class Building {
	
	Building()
	{
		System.out.println("b");
	}
	Building(String name)
	{
		this();
		System.out.println("bn " + name);
	}
}
class House extends Building{
	House()
	{
		System.out.println("h ");
	}
	House(String name)
	{
		this();
		System.out.println("hn " + name);
	}
	public static void main(String[] args)
	{
		new House("x ");
	}
}
