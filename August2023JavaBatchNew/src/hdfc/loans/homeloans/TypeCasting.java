package hdfc.loans.homeloans;

public class TypeCasting 
{

	public static void main(String[] args) 
	{
		//byte-1, char-2, short-2, int-4, long-8, float-4, double-8
		
		// 1 liter ---> 500 ml  ---> There is no risk ---> widining
		// 1-liter ---> 1.5 ltr ---> There is a risk(water overflow)  ---> Narrowing
		
		// Type casting from one primitive type to another primitive type
		
		int x1 = 10;
		System.out.println(x1);
		
		//double x2 = x1;
		double x2 = (double)x1;
		System.out.println(x2);
		
		double y1 = 12.34;
		System.out.println(y1);
		
		int y2 = (int) y1;
		System.out.println(y2);
		
		char c1 = 'A';
		System.out.println(c1);
		
		int c2 = (int)c1;
		System.out.println(c2);
		
		
		// Type casting from one primitive type to corresponding wapper class type
		
		int p1 = 100;
		System.out.println(p1);
		
		//Integer p2 = p1;
		Integer p2 = Integer.valueOf(p1);
		System.out.println(p2);
		
		Integer k1 = 10;
		System.out.println(k1);
		
		int k2 = (int)k1;
		System.out.println(k2);
		
		// Type casting from one wapper class type to another wapper class type
		
		String s1 = "200";
		String s2 = "300";
		
		System.out.println(s1+s2);
		
		float f1 = Float.parseFloat(s1);
		float f2 = Float.parseFloat(s2);
		System.out.println(f1+f2);
		
		int fp1 = Integer.parseInt(s1);
		int fp2 = Integer.parseInt(s2);
		System.out.println(fp1+fp2);
		
		Integer d1 = Integer.valueOf(fp1);
		Integer d2 = Integer.valueOf(fp2);
		System.out.println(d1+d2);

	}

}
