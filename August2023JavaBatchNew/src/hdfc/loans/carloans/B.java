package hdfc.loans.carloans;

public class B extends A // ISA Relationship
{
	public void m2()
	{
		System.out.println("iam m2 from B");
	}
	public void m1()
	{
		System.out.println("iam overrden m1 from B");
	}
	
	public static void main(String[] args) 
	{
		A a = new A(); // HasA Relationship
		a.m1();
		System.out.println(a.x);
		
		B b = new B();
		b.m2();
		b.m1();
		System.out.println(b.x);
	}

}
