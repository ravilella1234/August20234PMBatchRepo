package hdfc.loans.carloans;

public class Icici implements Rbi
{

	public static void main(String[] args) 
	{
		Icici i = new Icici();
		i.withdrawl();
		i.deposit();
	}

	@Override
	public void withdrawl() {
		System.out.println("iam overriden withdrawl in ICICI");
	}

	@Override
	public void deposit() {
		System.out.println("iam overriden deposit in ICICI");
	}

}
