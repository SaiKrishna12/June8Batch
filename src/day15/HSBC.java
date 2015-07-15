package day15;

public class HSBC {

	
	public static void main(String[] args) {
		HSBC h=new HSBC();
		h.debit();
		h.credit();
		h.moneyTranfer();

	}


	public void debit() {
		
		System.out.println("Debit process in hsbc");
	}


	public void credit() {
		System.out.println("Crediting procedure");
		
	}


	public void moneyTranfer() {
		System.out.println("Money Transfer policy");
		
	}

}
