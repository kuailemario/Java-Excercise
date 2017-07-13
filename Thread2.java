package b;

public class Thread2 {
	public static void main(String[] args)
	{
		Account account1 = new Account(100);
		ExThread thread1,thread2,thread3,thread4;
		thread1 = new ExThread("A",account1);
		thread2 = new ExThread("B",account1);
		thread3 = new ExThread("C",account1);
		thread4 = new ExThread("D",account1);
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}
}

class ExThread extends Thread
{
	Account ac;
	ExThread(String s,Account ac)
	{
		setName(s);
		this.ac = ac;
	}
	public void run()
	{
		ac.get(50);
		System.out.println("执行线程："+getName());
	}
}

class Account
{
	double balance;
	public Account(double d)
	{
		balance = d;
	}
	public synchronized void get(double i) //互斥操作
	{
		if(balance > 0)
		{
			try{
				Thread.sleep(100);
			}catch(Exception e){}
			balance = balance-i;
			System.out.println("取了"+i+",还剩"+balance);
		}
		else System.out.println("无法取款，已经没有钱了。");
	}
}
