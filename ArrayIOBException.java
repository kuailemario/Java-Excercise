package b;
import java.util.Random;
import java.util.Scanner;
public class ArrayIOBException {
	public static void main(String[] args)
	{
		Random r = new Random();
		int[] array1 = new int[100];
		for(int i=0; i<100; i++)
			array1[i]= r.nextInt(1000);
		Scanner input1 = new Scanner(System.in);
		int sc = input1.nextInt();
		try
		{
			if(sc<0 || sc>99)
				throw new ArithmeticException("Out of Bounds");
			System.out.printf("%d",array1[sc]);
		}
		catch(ArithmeticException ex)
		{
			System.out.println("Out of Bounds!");
		}
	}
}
