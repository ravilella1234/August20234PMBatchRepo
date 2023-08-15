package hdfc.loans.carloans;

public class Kotak implements Rbi
{

	public static void main(String[] args) 
	{
		Kotak k = new Kotak();
		k.deposit();
		k.withdrawl();
	}

	@Override
	public void withdrawl() {
		System.out.println("iam overriden withdrawl in Kotak");
	}

	@Override
	public void deposit() {
		System.out.println("iam overriden deposit in Kotak");
	}

}
