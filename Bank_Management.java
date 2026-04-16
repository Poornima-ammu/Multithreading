package java8amproject;

public class Bank_Management {
	public static void main(String[] args) {
		BankAccount bankAccount=new BankAccount();
		Thread cardPaymentThread=new cardPayment(bankAccount);
		Thread upiPaymentThread=new upiPayment(bankAccount);
		Thread MobileBankingThread=new mobileBanking(bankAccount);
		cardPaymentThread.start();
		upiPaymentThread.start();
		MobileBankingThread.start();
		cardPaymentThread.setName("cardPaymentThread");
		upiPaymentThread.setName("upiPaymentThread");
		MobileBankingThread.setName("MobileBankingThread");
	}

}
class mobileBanking extends Thread{
	BankAccount bankAccount;
	mobileBanking(BankAccount bankAccount){
		this.bankAccount=bankAccount;
	}
	public void run() {
		bankAccount.WithDraw(10000.0);
	}
}
class cardPayment extends Thread{
	BankAccount bankAccount;
	cardPayment(BankAccount bankAccount){
		this.bankAccount=bankAccount;
	}
	public void run() {
		bankAccount.WithDraw(10000.0);
	}

}
class upiPayment extends Thread{
	BankAccount bankAccount;
	upiPayment(BankAccount bankAccount){
		this.bankAccount=bankAccount;
	}
	public void run() {
		bankAccount.WithDraw(10000.0);
	}
}
class BankAccount {
	Double totalBalance=20000.0;
	public synchronized void WithDraw(Double amount) {
		if(totalBalance>=amount) {
			totalBalance=totalBalance-amount;
			System.out.println("Payment Sucessfull from thread "+ Thread.currentThread().getName()+". The Amount "+amount+" is debited.The available balance is "+totalBalance);
		}
		else {
			throw new insufficentBalanceException(Thread.currentThread().getName()+" Payment failed due to insufficent balance for amount  "+amount );
		}
		
	}
}
class insufficentBalanceException extends  RuntimeException{
	String message;
	insufficentBalanceException(String message){
		super(message);
	}
}
