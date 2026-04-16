class Test{
	public static void main(String []args){
	Runnable r=new CustomThread();
	Thread t=new Thread(r);
	t.setName("Runnable Thread");
	t.start();
	for(int i=0;i<10;i++){
		System.out.println("HELLO from "+Thread.currentThread().getName());
		}

	}
}
class CustomThread implements Runnable{
	public void run(){
	for(int i=0;i<10;i++){
		System.out.println("Hi from "+Thread.currentThread().getName());
		}
	}

}
