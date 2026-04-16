package java8amproject;

public class sychronisation {
	public static void main(String[]args) {
		ATM atm=new ATM();
		cardPayment1 t1=new cardPayment1(atm,"CARD-PAYMENT");
		mobileBanking1 t2=new mobileBanking1(atm,"MOBILE-BANKING");
		netBanking1 t3=new netBanking1(atm,"NET-BANKING");
		upiPayment1 t4=new upiPayment1(atm,"UPI-PAYMENT");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
		
}
class cardPayment1 extends Thread{
	ATM atm;
	cardPayment1(ATM atm,String name){
		super(name);
		this.atm=atm;
	}
	public void run() {
		atm.withDraw(20000);
		
	}
	
}
class mobileBanking1 extends Thread{
	ATM atm;
	mobileBanking1(ATM atm,String name){
		super(name);
		this.atm=atm;
	}
	public void run() {
		atm.withDraw(20000);
	}
	
}
class netBanking1 extends Thread{
	ATM atm;
	netBanking1(ATM atm,String name){
		super(name);
		this.atm=atm;
	}
	public void run() {
		atm.withDraw(20000);
	}
	
}
class upiPayment1 extends Thread{
	ATM atm;
	upiPayment1(ATM atm ,String name){
		super(name);
		this.atm=atm;
	}
	public void run() {
		atm.deposit(200000);
	}
}
 class ATM{
	int totalBalance=10000;
	public synchronized void withDraw(int amount) {
		while(amount>totalBalance) {
			try {
				this.wait();
			}
			catch(Exception e) {
			e.printStackTrace();
			}	
		}
		    totalBalance-=amount;
			System.out.println("Transcation Sucessfull."+amount+" is debited sucessfully by "+Thread.currentThread().getName()+ " Available balance is "+totalBalance);	
	}
	public  synchronized void deposit(int amount) {
		totalBalance+=amount;
		System.out.println("Transcation Sucessfull."+amount+" is credited  sucessfully.Available balance "+totalBalance);
		try {
			this.notify();
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
	}
 }