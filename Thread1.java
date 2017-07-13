package b;

public class Thread1 {
	public static void main(String[] args)
	{
		ExampleThread thread1,thread2,thread3;
		thread1 = new ExampleThread("A");
		thread2 = new ExampleThread("B");
		thread3 = new ExampleThread("C");
		thread1.start();
		thread2.start();
		thread3.start();
	}
}

class ExampleThread extends Thread
{
	ExampleThread(String s)
	{
		setName(s);
	}
	public void run()
	{
		for(int i=0;i<5;i++)
		System.out.println("Ö´ÐÐÏß³Ì£º"+getName());
	}
}