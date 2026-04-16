package java8amproject;
public class threadLifeCycle2 {
	public static void main(String args[]) {
	Thread mt=Thread.currentThread();
	mt.setName("Main Thread");
Thread t=new customThread1(mt);
t.setName("Custom Thread");
t.start();
for(int i=0;i<10;i++) {
	System.out.println("Hello world from"+ Thread.currentThread().getName());
	
}}}
class customThread1 extends Thread{
	Thread mt;
	customThread1(Thread mt){
		this.mt=mt;
	}
	public void run(){
		for(int i=0;i<10;i++) {
			if(i==8) {
				try{
					mt.join();
				}
				catch(Exception e) {
				e.printStackTrace();
				}}
			System.out.println("Java Program"+ Thread.currentThread().getName());
		}
	}
	
}
