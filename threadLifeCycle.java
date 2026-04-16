package java8amproject;
public class threadLifeCycle {
	public static void main(String[] args) {
		Thread mt=Thread.currentThread();// creation of thread
		Thread t=new customThread(mt);// Passing main Thread  as a parameter to thread t
		t.setName("custom Thread");
		t.start();
		for(int i=0;i<10;i++) {
			if(i==6) {
				try {
					t.join();// Thread goes to waiting stay 
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Java from  "+Thread.currentThread().getName());
			
			}	
	}
}
class customThread extends Thread{
	Thread mt;
	customThread(Thread mt){
		this.mt=mt;
	}
	public void run() {
		for(int i=0;i<10;i++) {
			try{
				Thread.currentThread().sleep(2000);
			}
			catch(Exception e) {
				e.printStackTrace();
				
			}
			System.out.println("Hello world from"+Thread.currentThread().getName());
			
		}
	}
}