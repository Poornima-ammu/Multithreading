class test{
	public static void main(String args[]){
		Thread t=new multithreadingIntro();
		t.start();
		// invokes start() present in thread class-->Contains logic for creating thread,executing thread,invoking run method
		for(int i=1;i<=10;i++){
		System.out.println("Hello "+i+":"+Thread.currentThread().getName());
		}

	}
}
	public  class multithreadingIntro extends Thread{
		/*public void start(){
		System.out.println("hi");
		}
		*/
		public void run(){
			for(int i=0;i<10;i++)
			{
			System.out.println("Hi "+ i   +" :"+Thread.currentThread().getName());
			}
		}
}

		
