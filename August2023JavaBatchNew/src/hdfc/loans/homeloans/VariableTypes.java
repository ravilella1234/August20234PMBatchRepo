package hdfc.loans.homeloans;

public class VariableTypes 
{
	//primitive variable
	int x = 100; // primitive instance variable
	static String cname = "vmware"; // primitive static variable
	static VariableTypes obj;
	
	public void m1()
	{
		int y =200; // primitive local variable
		int x = 300; 
		System.out.println(y);
		System.out.println(x);
		System.out.println(this.x);
		System.out.println(cname);
	}
	
	public static void m2()
	{
		 obj = new VariableTypes();
		System.out.println(obj.x);
		System.out.println(VariableTypes.cname);
	}
	
	public static void main(String[] args) 
	{
		//non-primitive variable
		 obj = new VariableTypes();
		System.out.println(obj.x);
		System.out.println(VariableTypes.cname);		
	}

}
